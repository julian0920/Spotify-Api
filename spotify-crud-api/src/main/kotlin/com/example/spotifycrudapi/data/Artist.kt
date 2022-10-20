package com.example.spotifycrudapi.data

import javax.persistence.*

@Entity
@Table(name = "artist")
data class Artist(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private val id: Long,

    private val name: String,

    private val popularity: Int,

    @ElementCollection
    private val genres: Set<String>
)