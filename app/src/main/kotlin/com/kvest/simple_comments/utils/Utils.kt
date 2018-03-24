package com.kvest.simple_comments.utils

import android.content.Context
import android.provider.Settings
import android.provider.Settings.Secure
import com.kvest.simple_comments.SimpleCommentsApp


/**
 * Created by kvest on 2/5/18.
 */
fun getDeviceId(context: Context) = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

val Context.app: SimpleCommentsApp
    get() = applicationContext as SimpleCommentsApp