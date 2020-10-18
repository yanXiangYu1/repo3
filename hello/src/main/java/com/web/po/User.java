package com.web.po;

public class User {
    private String username;
    private int age;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getRolename() {
        return Rolename;
    }

    public void setRolename(String rolename) {
        Rolename = rolename;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /*用户权限*/
    private String Rolename;
}
