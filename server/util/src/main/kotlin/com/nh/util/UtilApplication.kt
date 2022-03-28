package com.nh.util

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class UtilApplication

fun main(args: Array<String>) {
	runApplication<UtilApplication>(*args)
}
