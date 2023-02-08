package com.albert.instance.dao.impl;

import com.albert.instance.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
    public StudentDaoImpl() {
        System.out.println("StudentDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("StudentDaoImpl save");
    }
}
