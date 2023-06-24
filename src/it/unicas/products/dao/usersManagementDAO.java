package it.unicas.products.dao;

import it.unicas.products.dbutil.DBUtil;
import it.unicas.products.pojo.Product;
import it.unicas.products.pojo.Users;
import org.apache.struts2.ServletActionContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersManagementDAO {

    public static List<Users> getAllUsers(String nameUser) {
        List<Users> usersList = new ArrayList<Users>();
        String whereClause = "";
        if ((nameUser == null || nameUser.equals(""))) {
            whereClause = "";
        } else {
            whereClause = " WHERE ";
        }
        int count = 0;
        if (nameUser != null && !nameUser.equals("")) {
            count++;
            if (count != 1) {
                whereClause += " AND ";
            }
            whereClause += "user_name = " + "'" + nameUser + "'";
        }
        try {
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            System.out.println("SELECT * FROM login_info" + whereClause);
            ResultSet rs = st.executeQuery("SELECT * FROM login_info" + whereClause);
            while (rs.next()) {
//                rs.getInt("idlogin_info"),
                   Users users = new Users(rs.getString("user_name"),rs.getString("password"));
                usersList.add(users);
            }
            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersList;
    }


    public static int addProduct(Users users) {
        int status = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO login_info (user_name, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, users.getUser_name());
            ps.setString(2, users.getPassword());
            status = ps.executeUpdate();

            // Retrieve the generated auto-increment value
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                users.setIdlogin_info(generatedId);  // Set the generated ID on the user object if needed
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateUser(Users users) {
        int status = 0;
        Integer user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE login_info SET user_name=?, password=? WHERE user_id=?");
            ps.setString(1, users.getUser_name());
            ps.setString(2, users.getPassword());
            ps.setInt(3, user_id);
            status = ps.executeUpdate();
            if (status == 0) {
                throw new SQLException("Failed to update glucose measurement.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
