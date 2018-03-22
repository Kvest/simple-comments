package com.kvest.simple_comments.ui.comments_list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kvest.simple_comments.data.FirebaseRepository
import com.kvest.simple_comments.model.Comment

/**
 * Created by kvest on 1/29/18.
 */
class CommentsListViewModel(private val deviceId: String) : ViewModel() {
    private val rawComments by lazy { FirebaseRepository().getComments() }
    private val likes by lazy { FirebaseRepository().getLikes(deviceId) }
    private val merge = MediatorLiveData<List<CommentsListItem>>()
    private var commentsData: List<Comment>? = null
    private var likesData: Map<String, Int>? = null

    val comments: LiveData<List<CommentsListItem>>
        get() = merge

    init {
        merge.addSource(rawComments) {
            onNewData(it ?: emptyList(), likesData)
        }
        merge.addSource(likes) {
            onNewData(commentsData, it ?: emptyMap())
        }
    }

    private fun onNewData(newCommentsData: List<Comment>?, newLikesData: Map<String, Int>?) {
        commentsData = newCommentsData
        likesData = newLikesData

        if (newCommentsData != null && newLikesData != null) {
            merge.value = newCommentsData.map {
                Log.d("KVEST_TAG", it.toString())
                CommentsListItem(it.id,
                        it.comment,
                        it.countUp,
                        it.countDown,
                        newLikesData[it.id] == 1,
                        newLikesData[it.id] == -1)
            }
        }
    }
}