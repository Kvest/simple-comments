package com.kvest.simple_comments.data

import android.arch.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import com.kvest.simple_comments.firebase_helpers.asLiveData
import com.kvest.simple_comments.model.Comment

/**
 * Created by kvest on 1/29/18.
 */
class FirebaseRepository : Repository {
    override fun getComments(): LiveData<List<Comment>?> =
        FirebaseDatabase
                .getInstance()
                .getReference(PATH_COMMENTS)
                .asLiveData(CommentsDeserializer())


    override fun getComment(commentId: String): LiveData<Comment?> =
            FirebaseDatabase
                    .getInstance()
                    .getReference(PATH_COMMENTS)
                    .child(commentId)
                    .asLiveData(CommentDeserializer())
}