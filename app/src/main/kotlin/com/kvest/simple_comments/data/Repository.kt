package com.kvest.simple_comments.data

import android.arch.lifecycle.LiveData
import com.kvest.simple_comments.firebase_helpers.AddValueListener
import com.kvest.simple_comments.model.Comment
import com.kvest.simple_comments.model.NewComment

/**
 * Created by kvest on 1/29/18.
 */
interface Repository {
    fun getComments(): LiveData<List<Comment>?>
    fun getComment(commentId: String): LiveData<Comment?>
    fun addComment(comment: NewComment, resultListener: AddValueListener)
}