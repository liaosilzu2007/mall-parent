package com.lzumetal.mall.api.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public class SpringMybatisConfig {

//    @Autowired
//    private DataSourceConfig dataSourceConfig;

    @Autowired
    private SqlSessionFactoryConfig sqlSessionFactoryConfig;

//    @Bean(value = "dataSource")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        try {
//            dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
//            dataSource.setUrl(dataSourceConfig.getUrl());
//            dataSource.setUsername(dataSourceConfig.getUsername());
//            dataSource.setPassword(dataSourceConfig.getPassword());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return dataSource;
//    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactory factory = null;
        try {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.properties"));
            //bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            //bean.setTypeAliasesPackage("com.lzumetal.mall.pojo");
            factory = bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return factory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
