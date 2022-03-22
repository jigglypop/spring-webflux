package com.example.todo.domain

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id

@Entity
data class Todo(
    @Id
    val id: Long,
    val title: String,
)