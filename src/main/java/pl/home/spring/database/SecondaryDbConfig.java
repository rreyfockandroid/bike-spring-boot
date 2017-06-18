package pl.home.spring.database;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "secondaryEntityManagerFactory",
  transactionManagerRef = "secondaryTransactionManager",
  basePackages = { "pl.home.spring.database.secondary.dao" }
)
public class SecondaryDbConfig {
 
  @Bean(name = "secondaryDataSource")
  @ConfigurationProperties(prefix = "secondary.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "secondaryEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  secondaryEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("secondaryDataSource") DataSource dataSource
  ) {
    return
      builder
        .dataSource(dataSource)
        .packages("pl.home.spring.database.secondary.entity")
        .persistenceUnit("secondaryEM")
        .build();
  }

  @Bean(name = "secondaryTransactionManager")
  public PlatformTransactionManager barTransactionManager(
    @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory
    secondaryEntityManagerFactory
  ) {
    return new JpaTransactionManager(secondaryEntityManagerFactory);
  }
}