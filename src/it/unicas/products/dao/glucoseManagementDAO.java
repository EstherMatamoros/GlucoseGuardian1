package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.Glucose;

import java.sql.*;
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
            Statement st = conn.createStatement();
            String query = "SELECT measurement, createdDate, `timestamp`, id  FROM glucose" + whereClause;
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Glucose glucose = new Glucose(rs.getInt("measurement"), rs.getString("createdDate"));
                glucose.setId(rs.getInt("id"));
                glucose.setTimestamp(rs.getTimestamp("timestamp"));
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

    public static Glucose getGlucoseByIDAndTimestamp(Integer id, Timestamp timestamp) {
        Glucose glucose = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT measurement, createdDate, user_id FROM glucose WHERE id = ? AND `timestamp` = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setTimestamp(2, timestamp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                glucose = new Glucose(rs.getInt("measurement"), rs.getString("createdDate"));
                glucose.setId(id);
                glucose.setTimestamp(timestamp);
                glucose.setUser_id(userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return glucose;
    }

    public static int addGlucose(Glucose glucose) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO glucose (measurement, createdDate, user_id, `timestamp`) VALUES (?, ?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, glucose.getMeasurement());
            ps.setString(2, glucose.getCreatedDate());
            ps.setInt(3, glucose.getUser_id());

            // Set the current timestamp
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, currentTimestamp);

            status = ps.executeUpdate();

            // Retrieve the generated auto-increment value
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                glucose.setId(generatedId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateGlucose(Glucose glucose, Timestamp timestamp) {
        int status = 0;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE glucose SET measurement=?, createdDate=? WHERE id=? AND user_id=?");
            ps.setInt(1, glucose.getMeasurement());
            ps.setString(2, glucose.getCreatedDate());
            ps.setInt(3, glucose.getId());
            ps.setInt(4, glucose.getUser_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteGlucose(Timestamp timestamp) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM glucose where `timestamp` = ?");
            ps.setTimestamp(1, timestamp);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}