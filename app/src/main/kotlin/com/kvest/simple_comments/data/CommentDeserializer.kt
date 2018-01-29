package com.kvest.simple_comments.data

import com.google.firebase.database.DataSnapshot
import com.kvest.simple_comments.firebase_helpers.Deserializer
import com.kvest.simple_comments.model.Comment

/**
 * Created by kvest on 1/29/18.
 */
class CommentDeserializer : Deserializer<Comment> {
    override fun deserialize(dataSnapshot: DataSnapshot?): Comment? =
        dataSnapshot?.getValue(Comment::class.java)?.also {
            it.id = dataSnapshot.key
        }
}