package com.example.demo.Model;

import java.util.Date;

public class ProxiesPriv {
    private String host;

    private String user;

    private String proxiedHost;

    private String proxiedUser;

    private Boolean withGrant;

    private String grantor;

    private Date timestamp;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getProxiedHost() {
        return proxiedHost;
    }

    public void setProxiedHost(String proxiedHost) {
        this.proxiedHost = proxiedHost == null ? null : proxiedHost.trim();
    }

    public String getProxiedUser() {
        return proxiedUser;
    }

    public void setProxiedUser(String proxiedUser) {
        this.proxiedUser = proxiedUser == null ? null : proxiedUser.trim();
    }

    public Boolean getWithGrant() {
        return withGrant;
    }

    public void setWithGrant(Boolean withGrant) {
        this.withGrant = withGrant;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor == null ? null : grantor.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}