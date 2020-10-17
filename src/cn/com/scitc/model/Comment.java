package cn.com.scitc.model;

import java.util.Date;

public class Comment {

    private Integer c_id;
    private String loginId;
    private String c_xinxi;
    private Date time;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getC_xinxi() {
        return c_xinxi;
    }

    public void setC_xinxi(String c_xinxi) {
        this.c_xinxi = c_xinxi;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
