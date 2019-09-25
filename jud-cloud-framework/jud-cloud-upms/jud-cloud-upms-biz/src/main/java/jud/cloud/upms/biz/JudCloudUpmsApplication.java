package jud.cloud.upms.biz;

import jud.cloud.commom.swagger.annotation.EnableJudCloudSwagger2;
import jud.cloud.common.security.annotation.EnableJudCloudFeignClients;
import jud.cloud.common.security.annotation.EnableJudCloudResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 用户管理中心
 */
@EnableJudCloudSwagger2
@SpringCloudApplication
@EnableJudCloudFeignClients
@EnableJudCloudResourceServer(details = true)
public class JudCloudUpmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudCloudUpmsApplication.class, args);
    }
}
