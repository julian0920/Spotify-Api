package com.example.spotifycrudapi

import com.example.spotifycrudapi.repositories.AlbumRepository
import com.example.spotifycrudapi.repositories.ArtistRepository
import com.example.spotifycrudapi.spotify.service.SpotifyArtistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["com/example/spotifycrudapi/model"])
@EnableJpaRepositories(basePackages = ["com/example/spotifycrudapi/repositories"])
class SpotifyCrudApiApplication : CommandLineRunner {

    @Autowired
    val spotifyArtistService = SpotifyArtistService()

    @Autowired
    lateinit var albumRepository: AlbumRepository

    @Autowired
    lateinit var artistRepository: ArtistRepository

    override fun run(vararg args: String?) {
        albumRepository.saveAll(spotifyArtistService.getArtistAlbumById("4zYX8Aa744hQ5O2hpAYQI3"))
        artistRepository.saveAll(spotifyArtistService.getSeveralArtistsByIds())
    }
}

fun main(args: Array<String>) {
    runApplication<SpotifyCrudApiApplication>(*args)
}
