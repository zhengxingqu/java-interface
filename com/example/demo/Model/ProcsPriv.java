package com.example.demo.Model;

import java.util.Date;

public class ProcsPriv {
    private String host;

    private String db;

    private String user;

    private String routineName;

    private String routineType;

    private String grantor;

    private String procPriv;

    private Date timestamp;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName == null ? null : routineName.trim();
    }

    public String getRoutineType() {
        return routineType;
    }

    public void setRoutineType(String routineType) {
        this.routineType = routineType == null ? null : routineType.trim();
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor == null ? null : grantor.trim();
    }

    public String getProcPriv() {
        return procPriv;
    }

    public void setProcPriv(String procPriv) {
        this.procPriv = procPriv == null ? null : procPriv.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}