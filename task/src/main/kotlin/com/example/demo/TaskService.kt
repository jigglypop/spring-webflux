package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TaskService  @Autowired constructor(val taskRepository: TaskRepository)  {
    fun createTask(task : Task) : Mono<Task> = taskRepository.save(task)
    fun getTask(id: String): Mono<Task> = taskRepository.findById(id)
    fun getAllTasks(): Flux<Task> = taskRepository.findAll()
    fun deleteTask(id: String): Mono<Void>  = taskRepository.deleteById(id)

}