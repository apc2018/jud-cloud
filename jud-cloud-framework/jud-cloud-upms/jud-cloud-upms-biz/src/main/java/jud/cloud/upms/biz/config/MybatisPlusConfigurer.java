package jud.cloud.upms.biz.config;

import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("jud.cloud.upms.biz.mapper")
public class MybatisPlusConfigurer {
    /**
     * Sequence主键自增
     *
     * @return 返回oracle自增类
     * @author zhenggc
     * @date 2019/1/2
     */
    @Bean
    public OracleKeyGenerator oracleKeyGenerator(){
        return new OracleKeyGenerator();
    }
}
