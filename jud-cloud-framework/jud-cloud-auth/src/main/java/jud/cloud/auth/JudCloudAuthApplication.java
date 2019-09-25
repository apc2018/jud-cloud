package jud.cloud.auth;

import jud.cloud.common.security.annotation.EnableJudCloudFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 认证授权中心
 */
@SpringCloudApplication
@EnableJudCloudFeignClients
public class JudCloudAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudCloudAuthApplication.class, args);
    }
}
