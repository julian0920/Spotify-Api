package com.example.spotifycrudapi.persistence

import jakarta.persistence.*

@Entity
@Table(name = "artist", uniqueConstraints = [UniqueConstraint(columnNames = ["id", "name"])])
class Artist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val artistId: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var popularity: Int?,

    @ElementCollection
    @CollectionTable(name = "Genres")
    val genres: Set<String>?,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    val album: Album?
)