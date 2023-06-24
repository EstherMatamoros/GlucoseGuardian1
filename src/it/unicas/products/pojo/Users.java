package it.unicas.products.pojo;

public class Users {

    private int idlogin_info;
    private String user_name;
    private String password;
    private Integer user_id;

    public Users( String user_name, String password) {
//        this.idlogin_info = idlogin_info;
        this.user_name = user_name;
        this.password = password;
    }

    public int getIdlogin_info() {
        return idlogin_info;
    }

    public void setIdlogin_info(int idlogin_info) {
        this.idlogin_info = idlogin_info;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idlogin_info=" + idlogin_info +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
