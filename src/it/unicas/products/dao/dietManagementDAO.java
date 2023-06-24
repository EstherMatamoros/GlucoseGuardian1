package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.DietInfo;


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
                dietList.add(dietInfo);
            }
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dietList;
    }

    public static int addDiet(DietInfo dietInfo) {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO diet_info (meal, carbs, datetime, user_id)  VALUES(?,?,?,?)");
            ps.setString(1, dietInfo.getMeal());
            ps.setInt(2, dietInfo.getCarbs());
            ps.setString(3, dietInfo.getDatetime());
            ps.setInt(4, dietInfo.getUser_id());
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
