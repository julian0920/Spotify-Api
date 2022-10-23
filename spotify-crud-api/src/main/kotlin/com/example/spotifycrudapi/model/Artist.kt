package com.example.spotifycrudapi.model

import javax.persistence.*

@Entity
@Table(name = "artist")
open class Artist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long,

    open var name: String?,

    open var popularity: Int?,

    @Column(name = "genres", nullable = true)
    @ElementCollection
    open var genres: Set<String>?
)