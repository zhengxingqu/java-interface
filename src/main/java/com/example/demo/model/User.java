package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "user")

public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;

    @NotNull(message = "用户名不能为null")
    @NotBlank(message = "用户名不能为空")
    @Column(name = "username")
    private String username;

    @NotNull(message = "密码不能为null")
    @NotBlank(message = "密码不能为空")
    @Column(name = "password")
    private String password;

    @Column(name = "registerTime")
    private Date registerTime;

    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
