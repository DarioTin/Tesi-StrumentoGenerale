package com.dariotintore.backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "activetokens")
public class Token {
    @Id
    @Column(name = "tokenid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenid;
    @Column(name = "email")
    private String email;
    @Column(name = "tk")
    private String token;

    public Token() {
    }

    public Token(Long tokenid, String email, String token) {
        this.tokenid = tokenid;
        this.email = email;
        this.token = token;
    }

    public Token(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public Long getTokenid() {
        return tokenid;
    }

    public void setTokenid(Long tokenid) {
        this.tokenid = tokenid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

