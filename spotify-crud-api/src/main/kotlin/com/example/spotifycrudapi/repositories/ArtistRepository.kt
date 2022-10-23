package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.model.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository : JpaRepository<Artist, Long> {
}