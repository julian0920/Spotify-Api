package com.example.spotifycrudapi.persistence

import javax.persistence.*

@Entity
@Table(name = "album")
class Album(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(name = "release_Date", nullable = true)
    var releaseDate: String?,

    @Column(name = "album_type", nullable = true)
    val type: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_FK")
    val artist: Artist
)
