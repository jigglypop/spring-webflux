package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class TaskController @Autowired constructor(val taskService: TaskService) {

    @PostMapping("/task")
    fun createTask (@RequestBody task : Task ) : Mono<ResponseEntity<Task>> = taskService.createTask(task)
        .map { ResponseEntity(it,  HttpStatus.CREATED) }

    @GetMapping("/task/{id}")
    fun getTask (@PathVariable id: String) : Mono<ResponseEntity<Task>> = taskService.getTask(id)
        .map { ResponseEntity(it, HttpStatus.OK) }
        .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))

    @GetMapping("/tasks")
    fun getAllTasks() : Flux<ResponseEntity<Task>> = taskService.getAllTasks()
        .map { ResponseEntity(it,HttpStatus.OK) }
        .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))


    @PutMapping("/task/{id}")
    fun updateTask(@PathVariable id : String, @RequestBody task : Task)  : Mono<ResponseEntity<Task>> =
        taskService.getTask(id)
            .flatMap { taskService.createTask(Task(id = it.id,
                title = task.title,
                description = task.description,
                dueDate = task.dueDate,
                done =  task.done)) }.map { ResponseEntity(it,HttpStatus.OK) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))


    @DeleteMapping("/task/{id}")
    fun deleteTask(@PathVariable id : String) : Mono<ResponseEntity<Void>> = taskService.deleteTask(id)
        .map { ResponseEntity<Void>(HttpStatus.OK) }

}