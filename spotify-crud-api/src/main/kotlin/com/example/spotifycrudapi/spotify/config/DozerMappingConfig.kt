package com.example.spotifycrudapi.spotify.config

import com.github.dozermapper.core.loader.api.BeanMappingBuilder
import org.springframework.context.annotation.Bean
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified
import se.michaelthelin.spotify.model_objects.specification.Artist

class DozerMappingConfig {

    /**
     * The Dozer mapper has a lot of functionalities as mapping options
     * I use the <code>BeanMappingBuilder</code> this is some way to use API Mapping with the Dozer Mapper.
     * @see <a href="https://dozer.sourceforge.net/documentation/apimappings.html">API Mapping</a>
     * Because the <code>BeanMappingBuilder</code> is an abstract class Kotlin uses "object expressions"
     * to create objects from abstract classes.
     * @see <a href="https://kotlinlang.org/docs/object-declarations.html#object-expressions">Object-expressions</a>
     */
    @Bean
    fun beanMappingBuilder() = object : BeanMappingBuilder() {
        override fun configure() {
            mapping(AlbumSimplified::class.java, com.example.spotifycrudapi.persistence.Album::class.java)
                .exclude("id")
                .fields("name", "name")
                .fields("releaseDate", "releaseDate")
                .fields("type.type", "type")
            mapping(Artist::class.java, com.example.spotifycrudapi.persistence.Artist::class.java)
                .exclude("id")
                .fields("name", "name")
                .fields("popularity", "popularity")
                .fields("genres", "genres")
        }
    }
}