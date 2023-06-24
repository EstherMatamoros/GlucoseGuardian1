package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.ExerciseInfo;
import org.apache.struts2.ServletActionContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                exerciseList.add(exerciseInfo);
            }

            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exerciseList;
    }

    public static int addExercise(ExerciseInfo exerciseInfo) {
        int status = 0;

        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO exercise_info (burned_calories, amount_time, date, user_id) VALUES(?,?,?,?)");
            ps.setInt(1, exerciseInfo.getBurned_calories());
            ps.setInt(2, exerciseInfo.getAmount_time());
            ps.setString(3, exerciseInfo.getDate());
            ps.setInt(4, exerciseInfo.getUser_id());
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
