package com.example.demo

import org.springframework.data.annotation.Id
import javax.persistence.*

@Entity
@Table(name = "task")
data class Task(
    @Id
    val id : String,
    val title: String,
    val description : String,
    val dueDate : String,
    val done : Boolean
    )
