package com.example.demo.Model;

import java.util.Date;

public class DjangoMigrations {
    private Integer id;

    private String app;

    private String name;

    private Date applied;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app == null ? null : app.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getApplied() {
        return applied;
    }

    public void setApplied(Date applied) {
        this.applied = applied;
    }
}