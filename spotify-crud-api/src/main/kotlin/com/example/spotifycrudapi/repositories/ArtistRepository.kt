package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.data.Artist
import org.springframework.data.jpa.repository.JpaRepository

interface ArtistRepository : JpaRepository<Artist, Long> {
}