package com.example.spotifycrudapi.repositories

import com.example.spotifycrudapi.persistence.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ArtistRepository : JpaRepository<Artist, Long> {

    @Query(value = "SELECT a FROM Artist a WHERE a.artistId = :artistId")
    fun findByArtistId(@Param("artistId") artistId: String): Optional<Artist>

    @Query(value = "DELETE FROM Artist WHERE artistId = :artistId")
    fun deleteByArtistId(@Param("artistId") artistId: String)


}