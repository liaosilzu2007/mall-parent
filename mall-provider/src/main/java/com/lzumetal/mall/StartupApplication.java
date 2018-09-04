package com.lzumetal.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liaosi
 * @date 2018-08-26
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);

//        new SpringApplicationBuilder(StartupApplication.class)
//                .properties("spring.config.location=classpath:/mybatis-config.properties")
//                .properties("spring.config.location=classpath:/datasource.yml")
//                .run(args);
    }
}
