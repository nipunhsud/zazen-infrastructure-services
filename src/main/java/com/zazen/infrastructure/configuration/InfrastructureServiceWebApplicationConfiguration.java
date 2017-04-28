package com.zazen.infrastructure.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.zazen.infrastructure")
@PropertySource(value={"file://yuvo/conf/application.properties"})
//"classpath:application.properties"})

public class InfrastructureServiceWebApplicationConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() throws ClassNotFoundException, SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		Class.forName("com.mysql.jdbc.Driver");
		//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("RDS_HOSTNAME"));
		dataSource.setUsername(environment.getRequiredProperty("RDS_USERNAME"));
		dataSource.setPassword(environment.getRequiredProperty("RDS_PASSWORD"));
		dataSource.getConnection();
		return dataSource;
	}


	/*
	 * Here you can specify any provider specific properties.
	 */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public ObjectMapper objectMapper()
	{
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper;
	}

	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory() throws ClassNotFoundException, SQLException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(
				new String[] { "com.zazen.infrastructure.v1.pojos" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}


	//	@Bean
	//	public Client elasticClient(){
	//		Settings setting=Settings.builder().put("cluster.name",
	//				"elasticsearch").build();
	//		TransportClient transportClient=new PreBuiltTransportClient(setting);
	//		transportClient.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("localhost", 9300)));
	//		return (Client)transportClient;
	//	}
}
