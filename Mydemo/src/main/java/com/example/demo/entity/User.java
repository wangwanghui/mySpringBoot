package com.example.demo.entity;


import org.hibernate.validator.constraints.NotEmpty;



public class User {


    private Integer id;


    @NotEmpty(message = "用户名不能为空")
    private String userName;  //用户名


    @NotEmpty(message = "密码不能为空")
    private String password;  //密码


    private String remarks; // 备注

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }

}