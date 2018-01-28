package com.kvest.simple_comments.firebase_helpers

import android.arch.lifecycle.LiveData
import com.google.firebase.database.*

/**
 * Created by kvest on 1/27/18.
 */
class FirebaseQueryLiveData<T>(private val query: Query,
                               private val deserializer: Deserializer<T>? = null) : LiveData<T?>() {
    private val listener = LiveDataValueEventListener()

    override fun onActive() {
        query.addValueEventListener(listener)
    }

    override fun onInactive() {
        query.removeEventListener(listener)
    }

    private inner class LiveDataValueEventListener : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot?) {
            if (deserializer != null) {
                value = deserializer.deserialize(dataSnapshot)
            } else {
                //in case T is not DataSnapshot - ClassCastException will be thrown
                value = dataSnapshot as T
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {
            value = null
        }
    }
}