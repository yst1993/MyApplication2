package com.example.admin.myapplication2;

/**
 * Created by Admin on 11/4/2016.
 */
public class User {

    private int _id;
    private String _emailAddr;
    private String _password;

    public User() {

    }

    public User(int id, String emailAddr, String password) {
        this._id = id;
        this._emailAddr = emailAddr;
        this._password = password;
    }

    public User(String emailAddr, String password) {
        this._emailAddr = emailAddr;
        this._password = password;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setEmailAddr(String emailAddr) {
        this._emailAddr = emailAddr;
    }

    public String getEmailAddr() {
        return this._emailAddr;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public String getPassword() {
        return this._password;
    }
}