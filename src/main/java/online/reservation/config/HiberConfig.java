package online.reservation.config;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
//@EnableTransactionManagement
@ComponentScan({"online.reservation"})
@PropertySource(value = { "classpath:application.properties" })
public class HiberConfig {

    @Autowired
    private Environment environment;

    // Create session factory
    private SessionFactory sessionFactory = null;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        System.out.println("sessionFactory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
   
        sessionFactory.setDataSource(data());
        sessionFactory.setPackagesToScan(new String[] {"online.reservation.model"});
       
        sessionFactory.setHibernateProperties(hibernateProperties());
        
        return sessionFactory;
    }

    @Bean
    public DataSource data() {
    	 System.out.println("datasource");
        DriverManagerDataSource dS = new DriverManagerDataSource();
        dS.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dS.setUrl(environment.getRequiredProperty("jdbc.url"));
        dS.setUsername(environment.getRequiredProperty("jdbc.username"));
        dS.setPassword(environment.getRequiredProperty("jdbc.password"));
        return (DataSource) dS;
    }

    public Properties hibernateProperties() {
    	 System.out.println("hibernate");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }


}
