package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.data.Album
import org.springframework.data.jpa.repository.JpaRepository

interface AlbumRepository : JpaRepository<Album, Long> {
}