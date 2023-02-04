package com.albert.dl.dao.impl;


import com.albert.dl.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private int connectionName;
    private String dataBaseName;

    public UserDaoImpl() {
        System.out.println("UserDaoImpl constructor is running");
    }

    public UserDaoImpl(int connectionName, String dataBaseName) {
        this.connectionName = connectionName;
        this.dataBaseName = dataBaseName;
    }

    public int getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(int connectionName) {
        this.connectionName = connectionName;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public void save() {
        System.out.println("UserDaoImpl save..." + getDataBaseName() + "," + getConnectionName());
    }
}
