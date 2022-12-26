package com.example.spotifycrudapi.persistence

import javax.persistence.*

@Entity
@Table(name = "artist")
class Artist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var popularity: Int?,

    @Column(nullable = true)
    @ElementCollection
    val genres: List<String>?,

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "artist")
    val albums: List<Album>?
)