package com.wjinyu.mybatis.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-15 08:28
 */
public class WjyFactoryBean implements FactoryBean {

    public WjyFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private Class mapperClass;

    @Override
    public Object getObject() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        return session.getMapper(mapperClass);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
