package com.wjinyu;

import com.wjinyu.annotation.MapperScan;
import com.wjinyu.service.OrderService;
import com.wjinyu.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-14 09:16
 */
@ComponentScan("com.wjinyu")
@MapperScan("com.wjinyu.mapper")
public class MyApplication {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyApplication.class);
        applicationContext.refresh();

        applicationContext.getBean("userService", UserService.class).test();
        applicationContext.getBean("orderService", OrderService.class).test();
    }
}
