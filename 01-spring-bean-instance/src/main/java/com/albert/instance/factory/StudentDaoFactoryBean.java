package com.albert.instance.factory;

import com.albert.instance.dao.StudentDao;
import com.albert.instance.dao.impl.StudentDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class StudentDaoFactoryBean implements FactoryBean<StudentDao> {

    //代替原始实例工厂创建对象得方法
    public StudentDao getObject() throws Exception {
        return new StudentDaoImpl();
    }

    public Class<?> getObjectType() {
        return StudentDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
