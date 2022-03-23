package com.example.content

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

@Configuration
open class R2DBCConfig: AbstractR2dbcConfiguration() {

    @Bean
    open override fun connectionFactory(): ConnectionFactory {
        return MySqlConnectionFactory.from(
            MySqlConnectionConfiguration.builder()
                .host("127.0.0.1")
                .password("1127star@")
                .port(3306)
                .database("test")
                .username("root")
                .build()
        )
    }
}