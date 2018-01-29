package com.kvest.simple_comments.ui.comments_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by robielok on 1/26/2018.
 */
private const val TAG = "CommentsListActivity"
class CommentsListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadComments()
    }

    private fun loadComments() {
        val commentsListViewModel = ViewModelProviders.of(this).get(CommentsListViewModel::class.java)

        commentsListViewModel.comments.observe(this, Observer {
            if (it != null) {
                //print all comments
                it.forEach{
                    Log.d(TAG, it.toString())
                }
            } else {
                Log.d(TAG, "Comments are null")
            }
        })
    }
}