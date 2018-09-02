package com.bpf.tokenAuth.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private Integer age;
    private String phone;
    @JsonIgnore
    private Date createTime;
    
    public User() {};
    
    public User(Integer id, String username, String password, Integer age, String phone, Date createTime) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", phone="
                + phone + ", createTime=" + createTime + "]";
    }   
}
