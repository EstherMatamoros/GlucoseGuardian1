package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.AppointmentsInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class appointmentManagementDAO {

    public static List<AppointmentsInfo> getAllAppointments(String area, String date, String doctor_name, Integer user_id) {
        List<AppointmentsInfo> appointmentsInfoList = new ArrayList<>();
        String whereClause = " WHERE user_id = " + user_id;

        if (area == null && date == null && doctor_name == null) {
            whereClause = "";
        } else {
            int count = 0;

            if (area != null && !area.isEmpty()) {
                count++;
                whereClause += " AND area = " + area;
            }
            if (date != null && !date.equals("")) {
                count++;
                whereClause += " AND date = '" + date + "'";
            }
            if (doctor_name != null && !doctor_name.isEmpty()) {
                count++;
                whereClause += " AND doctor_name = " + doctor_name;
            }
        }

        try {
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM appointments_info" + whereClause;
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                AppointmentsInfo appointmentsInfo = new AppointmentsInfo(rs.getString("area"), rs.getString("date"), rs.getString("doctor_name"));
                appointmentsInfo.setUser_id(rs.getInt("user_id"));
                appointmentsInfo.setAppointments_id(rs.getInt("appointments_id"));
                appointmentsInfoList.add(appointmentsInfo);
            }
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointmentsInfoList;
    }

    public static AppointmentsInfo getAppointmentByID(Integer appointments_id) {
        AppointmentsInfo appointmentsInfo = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT area, `date`, doctor_name, user_id FROM appointments_info WHERE appointments_id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, appointments_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                appointmentsInfo = new AppointmentsInfo(rs.getString("area"), rs.getString("date"), rs.getString("doctor_name"));
                appointmentsInfo.setUser_id(rs.getInt("user_id"));
                appointmentsInfo.setAppointments_id(appointments_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentsInfo;
    }

    public static int addAppointment(AppointmentsInfo appointmentsInfo) {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO appointments_info (area, date, doctor_name, user_id)  VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, appointmentsInfo.getArea());
            ps.setString(2, appointmentsInfo.getDate());
            ps.setString(3, appointmentsInfo.getDoctor_name());
            ps.setInt(4, appointmentsInfo.getUser_id());
            status = ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                appointmentsInfo.setAppointments_id(generatedId);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public static int updateAppointmentInfo(AppointmentsInfo appointmentsInfo) {
        int status = 0;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE appointments_info SET area =?, date=?, doctor_name=? WHERE user_id=? AND appointments_id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, appointmentsInfo.getArea());
            ps.setString(2, appointmentsInfo.getDate());
            ps.setString(3, appointmentsInfo.getDoctor_name());
            ps.setInt(4, appointmentsInfo.getUser_id());
            ps.setInt(5, appointmentsInfo.getAppointments_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteAppointmentInfo(Integer appointments_id) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM appointments_info where appointments_id = ?");
            ps.setInt(1, appointments_id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
