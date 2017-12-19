package com.my.sb.dbconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {

	
	@Bean(name="appDataSource")
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource barDataSource() {
        return DataSourceBuilder.create().build();
    }

	@Bean(name = "appEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("appDataSource") DataSource appDataSource) {
        return builder
                .dataSource(appDataSource)
                .packages("com.my.sb.model")
                .build();
    }

    @Bean(name = "appTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("appEntityManagerFactoryBean") EntityManagerFactory appEntityManagerFactoryBean) {
        return new JpaTransactionManager(appEntityManagerFactoryBean);
    }
}