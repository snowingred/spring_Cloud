package cn.tedu.sp04.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 海加尔金鹰
 * @author zhouwx
 * @Description:
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().
                setAddress("redis://47.96.95.213:6379").
                setPassword("Qazwsx~123");
        return Redisson.create(config);
    }
}
