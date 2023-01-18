package com.example.spotifycrudapi

import com.example.spotifycrudapi.persistence.Album
import com.example.spotifycrudapi.persistence.Artist
import com.example.spotifycrudapi.repositories.AlbumRepository
import com.example.spotifycrudapi.repositories.ArtistRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackageClasses = [Album::class, Artist::class])
@EnableJpaRepositories(basePackageClasses = [AlbumRepository::class, ArtistRepository::class])
class SpotifyCrudApiApplication

fun main(args: Array<String>) {
    runApplication<SpotifyCrudApiApplication>(*args)
}
