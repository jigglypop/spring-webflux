package com.example.todo.router

import com.example.todo.handler.TodoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class TodoRouter(private val handler: TodoHandler) {

    @Bean
    fun routerFunction() = nest(path("/todos"),
        router {
            listOf(
                GET("/", handler::findAll),
                GET("/{id}", handler::findTodoById),
                POST("/", handler::save)
            )
        }
    )

}