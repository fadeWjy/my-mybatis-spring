package com.wjinyu.annotation;

import com.wjinyu.mybatis.spring.WjyMapperScanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-15 10:39
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(WjyMapperScanRegistrar.class)
public @interface MapperScan {
    String value() default "";
}
