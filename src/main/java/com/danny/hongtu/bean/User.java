package com.danny.hongtu.bean;

public class User {
    private Long id;
    private String username;
    private String password;
    private boolean vip;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isVip() {
        return vip;
    }

    public User setVip(boolean vip) {
        this.vip = vip;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
