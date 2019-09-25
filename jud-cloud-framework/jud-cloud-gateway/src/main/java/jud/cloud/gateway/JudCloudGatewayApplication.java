package jud.cloud.gateway;

import jud.cloud.common.gateway.annotation.EnableJudCloudDynamicRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 网关
 */
@EnableJudCloudDynamicRoute
@SpringCloudApplication
public class JudCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudCloudGatewayApplication.class, args);
    }
}
