package com.example.content.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("test")
data class Test(
        @Id
        @Column("id")
        val id: Int,
        @Column("name")
        val name: String?
)
{
        constructor(id: Int) :
                this(id, null) {
                }

}