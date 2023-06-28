package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.DietInfo;
import it.unicas.products.pojo.ExerciseInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dietManagementDAO {

    public static List<DietInfo> getAllDiet(String meal, Integer carbs, String datetime, Integer user_id) {
        List<DietInfo> dietList = new ArrayList<>();
        String whereClause = " WHERE user_id = " + user_id;

        if (meal == null && carbs == null && datetime == null) {
            whereClause = "";
        } else {
            boolean isWhereAdded = false;

            if (meal != null && !meal.isEmpty()) {
                whereClause += " AND meal = '" + meal + "'";
                isWhereAdded = true;
            }
            if (carbs != null) {
                whereClause += isWhereAdded ? " AND " : " AND carbs = ";
                whereClause += carbs;
                isWhereAdded = true;
            }
            if (datetime != null && !datetime.isEmpty()) {
                whereClause += isWhereAdded ? " AND " : " AND datetime = '";
                whereClause += datetime + "'";
            }
        }

        try {
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM diet_info" + whereClause;
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DietInfo dietInfo = new DietInfo(rs.getString("meal"), rs.getInt("carbs"), rs.getString("datetime"));
                dietInfo.setUser_id(rs.getInt("user_id"));
                dietInfo.setDiet_id(rs.getInt("diet_id"));
                dietList.add(dietInfo);
            }
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dietList;
    }

    public static DietInfo getDietByID(Integer diet_id) {
        DietInfo dietInfo = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT meal, carbs, datetime, user_id FROM diet_info WHERE diet_id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, diet_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dietInfo = new DietInfo(rs.getString("meal"), rs.getInt("carbs"), rs.getString("datetime"));
                dietInfo.setUser_id(rs.getInt("user_id"));
                dietInfo.setDiet_id(diet_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dietInfo;
    }

    public static int addDiet(DietInfo dietInfo) {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO diet_info (meal, carbs, datetime, user_id)  VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dietInfo.getMeal());
            ps.setInt(2, dietInfo.getCarbs());
            ps.setString(3, dietInfo.getDatetime());
            ps.setInt(4, dietInfo.getUser_id());
            status = ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                dietInfo.setDiet_id(generatedId);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public static int updateDietInfo(DietInfo dietInfo) {
        int status = 0;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE diet_info SET meal =?, carbs=?, datetime=? WHERE user_id=? AND diet_id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dietInfo.getMeal());
            ps.setInt(2, dietInfo.getCarbs());
            ps.setString(3, dietInfo.getDatetime());
            ps.setInt(4, dietInfo.getUser_id());
            ps.setInt(5, dietInfo.getDiet_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteDietInfo(Integer diet_id) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM diet_info where diet_id = ?");
            ps.setInt(1, diet_id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
