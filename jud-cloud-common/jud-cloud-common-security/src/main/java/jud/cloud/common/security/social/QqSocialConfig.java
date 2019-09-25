package jud.cloud.common.security.social;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * qq登录配置信息
 */
@Component
@Data
@Configuration
@ConfigurationProperties(prefix = "social.qq")
public class QqSocialConfig {
    private String appid;
    private String secret;
}
