package com.example.todo.handler

import com.example.todo.domain.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import java.util.Objects

@Component
class TodoHandler(private val todoRepository: TodoRepository) {

    fun findAll(req: ServerRequest) = ok().body<List<Todo>>(todoRepository.findAll())

    fun findTodoById(req: ServerRequest) = ok().body<Todo>(todoRepository.findById(req.pathVariable("id")))

    fun save(req: ServerRequest) = req.bodyToMono(Todo::class.java)
        .flatMap { todo -> ok().body<Unit>(todoRepository.save(todo)) }
}
