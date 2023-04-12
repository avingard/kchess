package com.avingard.chess.config

import com.avingard.echo.server.configuration.GrpcServerConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServerConfig {

    @Bean
    fun configServer(): GrpcServerConfiguration {
        return GrpcServerConfiguration()
    }
}