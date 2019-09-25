package jud.cloud.common.security.component;

import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.security.annotation.EnableJudCloudResourceServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

@Slf4j
public class JudCloudSecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 根据注解值动态注入资源服务器的相关属性
     *
     * @param metadata 注解信息
     * @param registry 注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        if (registry.isBeanNameInUse(SecurityConstants.RESOURCE_SERVER_CONFIGURER)) {
            log.warn("本地存在资源服务器配置，覆盖默认配置:" + SecurityConstants.RESOURCE_SERVER_CONFIGURER);
            return;
        }

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(JudCloudResourceServerConfigurerAdapter.class);
        MutablePropertyValues mpv = new MutablePropertyValues();
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(
                EnableJudCloudResourceServer.class.getName());
        Object details = annotationAttributes.get("details");
        mpv.add("details", details);
        beanDefinition.setPropertyValues(mpv);
        registry.registerBeanDefinition(SecurityConstants.RESOURCE_SERVER_CONFIGURER, beanDefinition);

    }
}
