package com.kvest.simple_comments

import android.app.Application
import com.kvest.simple_comments.di.component.AppComponent
import com.kvest.simple_comments.di.component.DaggerAppComponent

/**
 * Created by kvest on 3/22/18.
 */
class SimpleCommentsApp : Application() {
    val appComponent: AppComponent by lazy { DaggerAppComponent.builder().build() }
}