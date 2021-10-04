package com.br.gook.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "EntityManagerFactory",
    basePackages = ["com.br.gook.repository"],
    transactionManagerRef = "TransactionFactory"
)
class RepositoryConfig {

    @Primary
    @Bean(name = ["DataSource"])
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .url("jdbc:postgresql://localhost:5432/gookScheduler")
            .username("postgres")
            .password("635294")
            .driverClassName("org.postgresql.Driver")
            .build()
    }

    @Primary
    @Bean(name = ["EntityManagerFactory"])
    fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("DataSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder.dataSource(dataSource)
            .packages("com.br.gook.model")
            .persistenceUnit("gook")
            .build()
    }

    @Primary
    @Bean(name = ["TransactionFactory"])
    fun transactionFactory(
        @Qualifier("EntityManagerFactory") entityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory.getObject()
        return transactionManager
    }
}
