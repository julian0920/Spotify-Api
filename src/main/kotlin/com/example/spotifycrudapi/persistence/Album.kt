package com.example.spotifycrudapi.persistence

import javax.persistence.*

@Entity
@Table(name = "album", uniqueConstraints = [UniqueConstraint(columnNames = ["id", "name"])])
class Album(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val albumId: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var releaseDate: String?,

    @Column(nullable = true)
    val type: String?,

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "album")
    val artists: Set<Artist>?
)
