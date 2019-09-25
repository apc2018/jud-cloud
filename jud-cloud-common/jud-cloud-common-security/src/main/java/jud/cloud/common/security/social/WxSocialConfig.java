package jud.cloud.common.security.social;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 微信登录配置
 */
@Component
@Data
@Configuration
@ConfigurationProperties(prefix = "social.wx")
public class WxSocialConfig {
    private String appid;
    private String secret;
}
