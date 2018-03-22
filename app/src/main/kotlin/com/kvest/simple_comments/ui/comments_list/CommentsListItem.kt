package com.kvest.simple_comments.ui.comments_list

/**
 * Created by kvest on 2/5/18.
 */
data class CommentsListItem(val id: String,
                            val comment: String,
                            val likesCount: Int,
                            val dislikesCount: Int,
                            val liked: Boolean,
                            val disliked: Boolean)