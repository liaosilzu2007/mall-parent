package com.lzumetal.mall.api.configuration;

/**
 * @author liaosi
 * @date 2018-08-26
 */
//@Component
//@PropertySource(value = "classpath:datasource.yml")
//@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfig {

    private String url;

    private String driverClassName;

    private String username;

    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
