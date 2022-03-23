package com.nh.auth.repository

import com.nh.auth.entity.User
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface UserRepository: R2dbcRepository<User, Int> {

}