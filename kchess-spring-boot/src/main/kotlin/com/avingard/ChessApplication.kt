package com.avingard

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator


@EnableR2dbcRepositories
@SpringBootApplication
class ChessApplication {
    @Bean
    fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer? {
        val initializer = ConnectionFactoryInitializer()
        if (connectionFactory != null) {
            initializer.setConnectionFactory(connectionFactory)
        }
        initializer.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
        return initializer
    }
}

fun main(args: Array<String>) {
    runApplication<ChessApplication>(*args)
}