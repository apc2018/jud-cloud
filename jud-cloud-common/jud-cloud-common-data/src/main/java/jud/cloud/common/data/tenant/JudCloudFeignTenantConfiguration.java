package jud.cloud.common.data.tenant;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 租户信息拦截
 */
@Configuration
public class JudCloudFeignTenantConfiguration {
    @Bean
    public RequestInterceptor judCloudFeignTenantInterceptor() {
        return new JudCloudFeignTenantInterceptor();
    }
}
