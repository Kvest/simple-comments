package com.kvest.simple_comments.di.component

import com.kvest.simple_comments.di.module.RepositoryModule
import com.kvest.simple_comments.ui.comments_list.CommentsListActivity
import dagger.Component
import javax.inject.Singleton


/**
 * Created by kvest on 3/22/18.
 */
@Singleton
@Component(modules = arrayOf(RepositoryModule::class))
interface AppComponent {
    fun inject(activity: CommentsListActivity)
}