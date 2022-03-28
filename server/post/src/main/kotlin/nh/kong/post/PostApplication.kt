package nh.kong.post

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(scanBasePackages = [":util"])
class PostApplication

fun main(args: Array<String>) {
	runApplication<PostApplication>(*args)
}
