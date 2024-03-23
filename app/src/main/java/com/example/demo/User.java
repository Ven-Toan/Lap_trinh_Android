package com.example.demo;

public class User {
    private String login, avatar_url, url;
    public User(){

    }

    public User(String login, String avatar_url, String url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
