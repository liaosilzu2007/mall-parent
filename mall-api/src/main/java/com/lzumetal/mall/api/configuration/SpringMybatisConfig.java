package com.lzumetal.mall.api.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import com.lzumetal.mall.api.configuration.bean.DatabaseConfigBean;
import com.lzumetal.mall.api.configuration.bean.MybatisConfigBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author liaosi
 * @date 2018-08-26
 */
@Configuration
public class SpringMybatisConfig {

    @Autowired
    private DatabaseConfigBean databaseConfig;

    @Autowired
    private MybatisConfigBean mybatisConfig;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
            dataSource.setDriverClassName(databaseConfig.getDriverClassName());
            dataSource.setUrl(databaseConfig.getUrl());
            dataSource.setUsername(databaseConfig.getUsername());
            dataSource.setPassword(databaseConfig.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }


    @Bean(value = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        System.err.println("========================== sqlSessionFactory 初始化 =================================");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //数据库
        factoryBean.setDataSource(dataSource);

        //分页插件
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        Interceptor interceptor = new PageInterceptor();
        interceptor.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[] {interceptor});

        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            factoryBean.setMapperLocations(resolver.getResources(mybatisConfig.getMapperLocations()));
            factoryBean.setTypeAliasesPackage(mybatisConfig.getTypeAliasesPackage());
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
