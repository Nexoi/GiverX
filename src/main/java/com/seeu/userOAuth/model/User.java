package com.seeu.userOAuth.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -8036219797322639507L;

    private String account;
    private String password;
    private Integer UID;
    private Long roleId;

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
