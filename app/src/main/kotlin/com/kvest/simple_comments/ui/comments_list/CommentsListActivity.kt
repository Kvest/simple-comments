package com.kvest.simple_comments.ui.comments_list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kvest.simple_comments.R
import com.kvest.simple_comments.ext.*
import com.kvest.simple_comments.utils.getDeviceId

/**
 * Created by robielok on 1/26/2018.
 */
private const val TAG = "CommentsListActivity"
class CommentsListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comments_list_activity)

        loadComments()
    }

    private fun loadComments() {
        val deviceId = getDeviceId(this)
        withViewModel({CommentsListViewModel(deviceId)}) {
            observe(comments, ::onNewComments)
        }
    }

    private fun onNewComments(comments: List<CommentsListItem>?) {
        if (comments != null) {
            Log.d(TAG, "Comments count=${comments.size}")
            //print all comments
            comments.forEach{
                Log.d(TAG, it.toString())
            }
        } else {
            Log.d(TAG, "Comments are null")
        }
    }
}