package com.wjinyu.mybatis.spring;

import com.wjinyu.annotation.MapperScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-15 10:42
 */
public class WjyMapperScanRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(MapperScan.class.getName());
        String path = (String)annotationAttributes.get("value");
        WjyMapperScanner wjyMapperScanner = new WjyMapperScanner(beanDefinitionRegistry);
        wjyMapperScanner.scan(path);
    }
}
