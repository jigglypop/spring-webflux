
pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}

rootProject.name = "kong"

include("api")
include("util")
include("post")
include("comment")
include("recommendation")