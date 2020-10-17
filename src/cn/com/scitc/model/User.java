package cn.com.scitc.model;

public class User {
    private Integer u_id;
    private String loginId;
    private String password;
    private String userName;
    private String mobile;
    private String u_flag;
    private String email;


    public String getU_flag() {
        return u_flag;
    }

    public void setU_flag(String u_flag) {
        this.u_flag = u_flag;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String setLoginId(String loginId) {
        this.loginId = loginId;
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }
}
