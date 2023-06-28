package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.ExerciseInfo;
import it.unicas.products.pojo.Glucose;
import org.apache.struts2.ServletActionContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class exerciseManagementDAO {

    public static List<ExerciseInfo> getAllExercise(Integer burned_calories, Integer amount_time, String date, Integer user_id) {
        List<ExerciseInfo> exerciseList = new ArrayList<>();
        String whereClause = " WHERE user_id = " + user_id;

        if (burned_calories == null && amount_time == null && (date == null || date.equals(""))) {
            whereClause = " WHERE user_id = " + user_id;
        } else {
            int count = 0;
            if (burned_calories != null) {
                count++;
                whereClause += " AND burned_calories = " + burned_calories;
            }
            if (amount_time != null) {
                count++;
                whereClause += " AND amount_time = " + amount_time;
            }
            if (date != null && !date.equals("")) {
                count++;
                whereClause += " AND date = '" + date + "'";
            }
        }

        try {
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM exercise_info" + whereClause;
            System.out.println(query); // Debug statement to check the generated SQL query
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ExerciseInfo exerciseInfo = new ExerciseInfo(rs.getInt("burned_calories"),
                        rs.getInt("amount_time"), rs.getString("date"));
                exerciseInfo.setUser_id(rs.getInt("user_id"));
                exerciseInfo.setExercise_id(rs.getInt("exercise_id"));
                exerciseList.add(exerciseInfo);
            }

            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exerciseList;
    }

    public static ExerciseInfo getExerciseByID(Integer exercise_id) {
        ExerciseInfo exerciseInfo = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT burned_calories, amount_time, `date`, user_id FROM exercise_info WHERE exercise_id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, exercise_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exerciseInfo = new ExerciseInfo(rs.getInt("burned_calories"), rs.getInt("amount_time"),rs.getString("date"));
                exerciseInfo.setExercise_id(exercise_id);
                exerciseInfo.setUser_id(rs.getInt("user_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exerciseInfo;
    }

    public static int addExercise(ExerciseInfo exerciseInfo) {
        int status = 0;

        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO exercise_info (burned_calories, amount_time, date, user_id) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, exerciseInfo.getBurned_calories());
            ps.setInt(2, exerciseInfo.getAmount_time());
            ps.setString(3, exerciseInfo.getDate());
            ps.setInt(4, exerciseInfo.getUser_id());
            status = ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                exerciseInfo.setExercise_id(generatedId);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public static int updateExerciseInfo(ExerciseInfo exerciseInfo) {
        int status = 0;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE exercise_info SET burned_calories = ?, amount_time =?, date=? WHERE user_id=? AND exercise_id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, exerciseInfo.getBurned_calories());
            ps.setInt(2, exerciseInfo.getAmount_time());
            ps.setString(3, exerciseInfo.getDate());
            ps.setInt(4, exerciseInfo.getUser_id());
            ps.setInt(5, exerciseInfo.getExercise_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteExerciseInfo(Integer exercise_id) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM exercise_info where exercise_id = ?");
            ps.setInt(1, exercise_id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
