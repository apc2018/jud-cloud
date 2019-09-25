package jud.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务中心
 */
@EnableEurekaServer
@SpringBootApplication
public class JudCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudCloudEurekaApplication.class, args);
    }
}
