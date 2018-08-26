package com.lzumetal.mall.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author liaosi
 * @date 2018-08-26
 */
@Component
@PropertySource(value = "classpath:mybatis-config.yml")
@ConfigurationProperties(prefix = "mybatisconfig")
public class SqlSessionFactoryConfig {

    private String mapperLocations;

    private String typeAliasesPackage;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
