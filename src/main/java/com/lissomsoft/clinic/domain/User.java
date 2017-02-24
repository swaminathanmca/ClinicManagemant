package com.lissomsoft.clinic.domain;

/**
 * Created by Admin on 2/16/2017.
 */
public class User {


    private String username;
    private String password;
    private String role_name;
    private String email_id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }



    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public  String toString(){
        return "User{"+
                "username="+username+
                ",role_name="+role_name+
                ",email_id="+email_id+

                '}';
    }
}
