package com.example.content.router

import com.example.content.handler.TestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
open class index {

    @Bean
    open fun testRouter(testHandler: TestHandler) = router {
        "/api/test".nest {
            GET("/",testHandler::readTests )
            GET("/{id}",testHandler::readTest )
            POST("", testHandler::createTest)
            PUT("/{id}", testHandler::putTest)
            DELETE("/{id}", testHandler::deleteTest)
        }
    }
}