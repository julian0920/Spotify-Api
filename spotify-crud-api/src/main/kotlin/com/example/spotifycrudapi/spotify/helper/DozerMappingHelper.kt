package com.example.spotifycrudapi.spotify.helper

import com.example.spotifycrudapi.spotify.config.DozerMappingConfig
import com.github.dozermapper.core.DozerBeanMapperBuilder
import kotlin.reflect.KClass

class DozerMappingHelper {

    private val mapper =
        DozerBeanMapperBuilder.create().withMappingBuilder(DozerMappingConfig().beanMappingBuilder()).build()

    /**
     * Generic Helper Method to map from a List of Type <code> F </code> to a List of Type <code> T </code>
     * @param source the source List of type <code> F </code> you want to map from
     * @param destination the Class of type <code> T </code> you want to map to
     * @return the mapped object as a list of type <code> T </code>
     */
    fun <F, T : Any> mapToList(source: List<F>, destination: KClass<T>): List<T> {
        val destinationObject: MutableList<T> = ArrayList()
        for (element: F in source) {
            destinationObject.add(mapper.map(element, destination.java))
        }
        return destinationObject
    }
}