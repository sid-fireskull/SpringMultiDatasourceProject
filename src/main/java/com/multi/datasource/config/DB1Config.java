package com.multi.datasource.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
		"com.multi.datasource.repository.dbFirst" })
public class DB1Config {
	
	
    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    DataSource dataSource()
	{
		return (DataSource) DataSourceBuilder.create().build();
	}
    
    @Primary
    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, 
    		@Qualifier("datasource") DataSource dataSource)
	{
		HashMap<String, Object> prop = new HashMap<>();
		prop.put("hibernate.hbm2ddl.auto", "update");
		
		return builder.dataSource(dataSource)
				  .properties(prop)
				  .packages("com.multi.datasource.model.dbFirst")
				  .persistenceUnit("db1")
				  .build();
	}
    
    
	@Primary
	@Bean(name = "transactionManager")
	PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
    
}
