package com.kvest.simple_comments.utils

import android.content.Context
import android.provider.Settings
import android.provider.Settings.Secure



/**
 * Created by kvest on 2/5/18.
 */
fun getDeviceId(context: Context) = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)