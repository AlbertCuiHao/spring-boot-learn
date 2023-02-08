package com.albert.dl.dao.impl;


import com.albert.dl.dao.BookDao;

public class BookDaoImpl implements BookDao {
    private int connectionName;
    private String dataBaseName;

    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
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
        System.out.println("BookDaoImpl save..." + getDataBaseName() + "," + getConnectionName());
    }
}
