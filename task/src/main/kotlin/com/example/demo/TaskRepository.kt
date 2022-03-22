package com.example.demo

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : ReactiveCrudRepository<Task, String>