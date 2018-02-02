package com.kvest.simple_comments.data

import android.arch.lifecycle.LiveData
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kvest.simple_comments.firebase_helpers.AddValueListener
import com.kvest.simple_comments.firebase_helpers.asLiveData
import com.kvest.simple_comments.model.Comment
import com.kvest.simple_comments.model.NewComment

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

    override fun addComment(comment: NewComment, resultListener: AddValueListener) {
        FirebaseDatabase
                .getInstance()
                .getReference(PATH_COMMENTS)
                .push()
                .setValue(comment, object: DatabaseReference.CompletionListener {
                    override fun onComplete(error: DatabaseError?, ref: DatabaseReference?) {
                        resultListener.onAddValueResult(error == null)
                    }
                })

    }
}