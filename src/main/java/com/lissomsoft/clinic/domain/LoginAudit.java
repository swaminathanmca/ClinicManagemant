package com.lissomsoft.clinic.domain;

/**
 * Created by Lissomsoft on 06/16/17.
 */
public class LoginAudit {

        private Integer audit_id;
        private String  password_token;
        private Integer status;
        private Integer user_id;


    public Integer getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Integer audit_id) {
        this.audit_id = audit_id;
    }

    public String getPassword_token() {
        return password_token;
    }

    public void setPassword_token(String password_token) {
        this.password_token = password_token;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String toString(){


        return "{"+
                "audit_id="+audit_id+
                "password_token="+password_token+
                "user_id="+user_id+
                "status="+status+
                '}';
    }
}
