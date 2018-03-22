package com.kvest.simple_comments.ui.comments_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kvest.simple_comments.R
import com.kvest.simple_comments.model.Comment

/**
 * Created by kvest on 2/3/18.
 */
class CommentsAdapter(context: Context, items: List<Comment>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    private val inflator = LayoutInflater.from(context)
    private var items = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(inflator.inflate(R.layout.comments_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Comment) = with(itemView) {
            // TODO: Bind the data with View
        }
    }
}