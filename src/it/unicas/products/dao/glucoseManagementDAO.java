package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.Glucose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class glucoseManagementDAO {

    public static List<Glucose> getAllGlucose(Integer measurement, String createdDate, Integer user_id) {
        List<Glucose> glucoseList = new ArrayList<>();
        String whereClause = " WHERE user_id = " + user_id;

        if(measurement == null && (createdDate == null || createdDate.equals(""))) {
            whereClause = " WHERE user_id = " + user_id;
        }
        else {
            int count = 0;
            if(measurement != null) {
                count ++;
                whereClause += "measurement = "+"'"+measurement+"'";
            }
            if(createdDate != null && !createdDate.equals("")) {
                count ++;
                if(count != 1) {
                    whereClause += " AND ";
                }
                whereClause += "createdDate = "+"'"+createdDate+"'";
            }
        }

        try
        {
            Connection conn = DBUtil.getConnection();
            Statement st= conn.createStatement();
            System.out.println("SELECT * FROM glucose"+whereClause);
            ResultSet rs= st.executeQuery("SELECT * FROM glucose"+whereClause);
            while(rs.next())
            {
                Glucose glucose = new Glucose(rs.getInt("measurement"),rs.getString("createdDate"));
                glucoseList.add(glucose);
            }

            DBUtil.closeConnection(conn);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return glucoseList;
    }

    public static int addGlucose(Glucose glucose) {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO glucose (measurement, createdDate, user_id) VALUES (?, ?,?)");
            ps.setInt(1, glucose.getMeasurement());
            ps.setString(2, glucose.getCreatedDate());
            ps.setInt(3, glucose.getUser_id());
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateGlucose(Glucose glucose) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE glucose SET measurement=?, createdDate=? WHERE `timestamp`=?");
            ps.setInt(1, glucose.getMeasurement());
            ps.setString(2, glucose.getCreatedDate());
            ps.setTimestamp(3, glucose.getTimestamp());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
