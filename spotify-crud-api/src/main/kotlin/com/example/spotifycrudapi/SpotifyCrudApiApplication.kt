package com.example.spotifycrudapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["com/example/spotifycrudapi/data"])
@EnableJpaRepositories(basePackages = ["com/example/spotifycrudapi/repositories"])
class SpotifyCrudApiApplication

fun main(args: Array<String>) {
	runApplication<SpotifyCrudApiApplication>(*args)
}
