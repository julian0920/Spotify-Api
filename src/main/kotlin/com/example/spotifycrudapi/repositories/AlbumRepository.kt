package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.persistence.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumRepository : JpaRepository<Album, Long>