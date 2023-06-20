package com.wjinyu.mybatis.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-15 11:32
 */
public class WjyMapperScanner extends ClassPathBeanDefinitionScanner {

    public WjyMapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
        //return super.isCandidateComponent(metadataReader) 判断类上面有没有@Component注解
        return true; // 我们不关心mapper上有没有@Component注解
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        //return super.isCandidateComponent(beanDefinition);
        return beanDefinition.getMetadata().isInterface(); // 我们关系mapper是不是接口
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder>  beanDefinitionHolders = super.doScan(basePackages);
        // beanDefinitionHolders就是扫描出来的Mapper接口
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            // 传参 mapper.class
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            // 改成 WjyFactoryBean.class
            beanDefinition.setBeanClass(WjyFactoryBean.class);
        }
        // 扫描完就会放到spring beanDefinition 注册
        return super.doScan(basePackages);
    }
}
