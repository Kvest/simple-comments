package com.kvest.simple_comments.ui.comments_list

import android.arch.lifecycle.ViewModel
import com.kvest.simple_comments.data.FirebaseRepository

/**
 * Created by kvest on 1/29/18.
 */
class CommentsListViewModel : ViewModel() {
    val comments by lazy { FirebaseRepository().getComments() }
}