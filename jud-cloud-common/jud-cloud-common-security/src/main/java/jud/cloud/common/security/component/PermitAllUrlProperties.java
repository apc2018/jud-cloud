package jud.cloud.common.security.component;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务器对外直接暴露URL
 */
@Component
@Data
@Configuration
@RefreshScope
@ConditionalOnExpression("!'${security.oauth2.client.ignore-urls}'.isEmpty()")
@ConfigurationProperties(prefix = "security.oauth2.client")
public class PermitAllUrlProperties {
    private List<String> ignoreUrls = new ArrayList<>();
}
