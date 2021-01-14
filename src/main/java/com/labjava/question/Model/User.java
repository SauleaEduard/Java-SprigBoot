package com.labjava.question.Model;

public class User {
    private String nick;
    private String email;
    private long id;

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public User() {
    }

    public User(String nick, String email, long id) {
        this.nick = nick;
        this.id = id;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public long getId() {
        return id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setId(long id) {
        this.id = id;
    }
}
