package com.kvest.simple_comments.firebase_helpers

import com.google.firebase.database.DataSnapshot

/**
 * Created by kvest on 1/27/18.
 */
interface Deserializer<out T> {
    fun deserialize(dataSnapshot: DataSnapshot?): T?

    companion object {
        fun <T> of(clazz: Class<T>): Deserializer<T?> {
            return object: Deserializer<T?> {
                override fun deserialize(dataSnapshot: DataSnapshot?): T? = dataSnapshot?.getValue(clazz)
            }
        }

        fun <T : Any> ofList(clazz: Class<T>): Deserializer<List<T>?> {
            return object: Deserializer<List<T>?> {
                override fun deserialize(dataSnapshot: DataSnapshot?): List<T>? =
                        dataSnapshot?.children?.mapNotNull {
                            it.getValue(clazz)
                        }
                }
        }

        fun <T> ofMap(clazz: Class<T>): Deserializer<Map<String, T>?> {
            return object: Deserializer<Map<String, T>?> {
                override fun deserialize(dataSnapshot: DataSnapshot?): Map<String, T>? =
                    dataSnapshot?.children?.mapNotNull {
                        val value = it.getValue(clazz)
                        if (value != null) {
                            Pair<String, T>(it.key, value)
                        } else {
                            null
                        }
                    }?.toMap()
            }
        }
    }
}

