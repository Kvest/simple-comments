package com.kvest.simple_comments.firebase_helpers

import android.arch.lifecycle.LiveData
import com.google.firebase.database.Query

/**
 * Created by kvest on 1/29/18.
 */

fun <T> Query.asLiveData(deserializer: Deserializer<T>? = null): LiveData<T?> {
    return FirebaseQueryLiveData(this, deserializer)
}