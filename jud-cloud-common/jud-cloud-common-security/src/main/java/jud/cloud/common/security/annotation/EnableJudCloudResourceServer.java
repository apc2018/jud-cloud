package jud.cloud.common.security.annotation;

import jud.cloud.common.security.component.JudCloudResourceServerAutoConfiguration;
import jud.cloud.common.security.component.JudCloudSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({JudCloudResourceServerAutoConfiguration.class, JudCloudSecurityBeanDefinitionRegistrar.class})
public @interface EnableJudCloudResourceServer {
    /**
     * false：上下文获取用户名
     * true： 上下文获取全部用户信息
     *
     * @return
     */
    boolean details() default false;
}
