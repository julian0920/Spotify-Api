package com.example.spotifycrudapi.model

import javax.persistence.*

@Entity
@Table(name = "album")
open class Album(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long,

    open var name: String,

    @Column(name = "release_Date", nullable = true)
    open var releaseDate: String?,

    @Column(name = "album_type", nullable = true)
    open var type: String?
)
