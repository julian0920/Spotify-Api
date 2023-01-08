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
    var name: String,

    @Column(name = "release_Date", nullable = true)
    var releaseDate: String?,

    @Column(name = "album_type", nullable = true)
    val type: String?,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "album_artist",
        joinColumns = [JoinColumn(name = "artist_id")],
        inverseJoinColumns = [JoinColumn(name = "album_id")]
    )
    val artists: List<Artist>
)
