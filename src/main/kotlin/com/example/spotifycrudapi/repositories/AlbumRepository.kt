package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.persistence.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AlbumRepository : JpaRepository<Album, Long> {

    @Query(value = "SELECT a FROM Album a WHERE a.albumId = :albumId")
    fun findByAlbumId(@Param("albumId") albumId: String): Optional<Album>

    @Query(value = "DELETE FROM Album WHERE albumId = :albumId")
    fun deleteByAlbumId(@Param("albumId") albumId: String)
}