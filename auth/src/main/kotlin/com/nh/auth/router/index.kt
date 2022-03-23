package com.nh.auth.router

import com.nh.auth.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
open class index {

    @Bean
    open fun userRouter(userHandler: UserHandler) = router {
        "/api/auth".nest {
            POST("/register", userHandler::register)
        }
    }
}