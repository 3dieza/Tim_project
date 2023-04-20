package com.bank.antifraud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конфигурационный класс приложения.
 * <p>
 * Осуществляет настройку источника данных, адаптера JPA, свойств Hibernate и сканирование сущностей.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.bank.antifraud.repository")
public class AppConfig {

    // Константа для свойств hibernate
    private static final String HIBERNATE_TRUE = "true";

    /**
     * Создает фабрику сущностей EntityManagerFactory для доступа к базе данных.
     *
     * @return фабрика сущностей EntityManagerFactory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

// Устанавливаем источник данных
        emf.setDataSource(dataSource());

// Устанавливаем пакет, в котором находятся сущности
        emf.setPackagesToScan("com.bank.antifraud.entity");

// Устанавливаем адаптер Hibernate
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

// Устанавливаем свойства Hibernate
        emf.setJpaProperties(jpaProperties());

        return emf;
    }

    /**
     * Создает источник данных для доступа к базе данных.
     *
     * @return источник данных
     */
    @Bean
    public DataSource dataSource() {
// Создаем новый источник данных
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

// Устанавливаем драйвер БД
        dataSource.setDriverClassName("org.postgresql.Driver");

// Устанавливаем URL БД
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");

// Устанавливаем имя пользователя БД
        dataSource.setUsername("users");

// Устанавливаем пароль пользователя БД
        dataSource.setPassword("password");

        return dataSource;
    }

    /**
     * Создает объект для хранения свойств Hibernate.
     *
     * @return объект для хранения свойств Hibernate
     */
    private Properties jpaProperties() {
// Создаем объект для хранения свойств Hibernate
        final Properties props = new Properties();

// Устанавливаем диалект PostgreSQL
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

// Устанавливаем флаг отображения SQL-запросов
        props.setProperty("hibernate.show_sql", HIBERNATE_TRUE);

// Устанавливаем флаг форматирования SQL-запросов
        props.setProperty("hibernate.format_sql", HIBERNATE_TRUE);

// Устанавливаем стратегию автоматического создания/обновления таблиц
        props.setProperty("hibernate.hbm2ddl.auto", "update");

        return props;
    }

}
