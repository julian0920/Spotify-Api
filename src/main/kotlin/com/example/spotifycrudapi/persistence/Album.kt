package com.example.spotifycrudapi.persistence

import javax.persistence.*

@Entity
@Table(name = "album")
class Album(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val albumId: String,

    @Column(nullable = false)
    var name: String,

    @Column(name = "release_Date", nullable = true)
    var releaseDate: String?,

    @Column(name = "album_type", nullable = true)
    val type: String?,

    @Column(nullable = true)
    @OneToMany(targetEntity = Artist::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val artists: Set<Artist>?
)
