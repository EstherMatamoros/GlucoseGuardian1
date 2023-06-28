package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.ExerciseInfo;
import it.unicas.products.pojo.MedicationInfo;
import it.unicas.products.pojo.Users;
import org.apache.struts2.ServletActionContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class medicationManagementDAO{

    public static List<MedicationInfo> getAllMedications(String name, Integer dose, String treatment_for, String date_started,
                                               String date_end, Integer user_id) {
        List<MedicationInfo> medicationList = new ArrayList<MedicationInfo>();
        String whereClause = " WHERE user_id = " + user_id;
        if((name == null || name.equals("")) && dose == null && (treatment_for == null || treatment_for.equals("")) &&
                (date_started == null || date_started.equals("")) && (date_end == null || date_end.equals(""))) {
            whereClause = " WHERE user_id = " + user_id;
        }
        else {
            int count = 0;
            if(name != null && !name.equals("")) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "name = "+"'"+name+"'";
            }
            if(dose != null) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "dose = "+"'"+dose+"'";
            }
            if(treatment_for != null && !treatment_for.equals("")) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "treatment_for = "+"'"+treatment_for+"'";
            }
            if(date_started != null && !date_started.equals("")) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "date_started = "+"'"+date_started+"'";
            }
            if(date_end != null && !date_end.equals("")) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "date_end = "+"'"+date_end+"'";
            };
        }

        try
        {
            Connection conn = DBUtil.getConnection();
            Statement st= conn.createStatement();
            System.out.println("SELECT * FROM medication_info "+whereClause);
            ResultSet rs= st.executeQuery("SELECT * FROM products.medication_info "+whereClause);
            while(rs.next())
            {
                MedicationInfo medicationInfo = new MedicationInfo(rs.getString("name"),rs.getInt("dose"),rs.getString("treatment_for"),rs.getString("date_started"),rs.getString("date_end"));
                medicationInfo.setUser_id(rs.getInt("user_id"));
                medicationInfo.setId(rs.getInt("id"));
                medicationList.add(medicationInfo);
            }

            DBUtil.closeConnection(conn);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return medicationList;
    }

//    add a getMedicationBy LoginINfo
    public static MedicationInfo getMedicationByID(Integer id) {
        MedicationInfo medicationInfo = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT name, dose, treatment_for, date_started, date_end, user_id FROM medication_info WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                medicationInfo = new MedicationInfo(rs.getString("name"),rs.getInt("dose"),rs.getString("treatment_for"),rs.getString("date_started"),rs.getString("date_end"));
                medicationInfo.setId(id);
                medicationInfo.setUser_id(userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicationInfo;
    }

    public static int addMedication(MedicationInfo medicationInfo, int userId) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO medication_info (name, dose, treatment_for, date_started, date_end, user_id) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medicationInfo.getName());
            ps.setInt(2, medicationInfo.getDose());
            ps.setString(3, medicationInfo.getTreatment_for());
            ps.setString(4, medicationInfo.getDate_started());
            ps.setString(5, medicationInfo.getDate_end());
            ps.setInt(6, userId);
            status = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                medicationInfo.setId(generatedId);
            }

//            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateMedication(MedicationInfo medicationInfo) {
        int status = 0;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE medication_info SET name=?, dose=?, treatment_for=?, date_started=?, date_end=?  WHERE user_id=? AND id =?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medicationInfo.getName());
            ps.setInt(2, medicationInfo.getDose());
            ps.setString(3, medicationInfo.getTreatment_for());
            ps.setString(4, medicationInfo.getDate_started());
            ps.setString(5, medicationInfo.getDate_end());
            ps.setInt(6, medicationInfo.getUser_id());
            ps.setInt(7, medicationInfo.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static int deleteMedicationInfo(Integer id) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM medication_info where id = ?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
