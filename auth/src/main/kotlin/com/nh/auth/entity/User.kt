package com.nh.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

data class UserForm (
    val id: Int?,
    val username: String?,
    val password: String?,
    val email: String?,
    val imageUrl: String?,
    val githubUrl: String?,
    val summary: String?,
)

@Table("user")
data class User (
    @Id
    @Column("id")
    val id: Int?,
    @Column("username")
    val username: String?,
    @Column("hashedPassword")
    val hashedPassword: String?,
    @Column("email")
    val email: String?,
    @Column("imageUrl")
    val imageUrl: String?,
    @Column("githubUrl")
    val githubUrl: String?,
    @Column("summary")
    val summary: String?,
)
{
    constructor(username: String?, hashedPassword: String?, email: String?, imageUrl: String?, githubUrl: String?, summary: String?) :
            this(null, username, hashedPassword, email, imageUrl, githubUrl, summary) {
    }
}