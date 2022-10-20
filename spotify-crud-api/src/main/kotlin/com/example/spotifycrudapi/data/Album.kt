package com.example.spotifycrudapi.data

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "album")
data class Album(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Long,
    private val name: String,
    private val releaseData: LocalDate,
    private val totalTracks: Int,
    private val type: String
)
