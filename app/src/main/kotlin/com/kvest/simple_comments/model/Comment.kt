package com.kvest.simple_comments.model

import com.google.firebase.database.PropertyName
import com.kvest.simple_comments.data.*

/**
 * Created by robielok on 1/26/2018.
 */
data class Comment(var id: String = "",
                   @get:PropertyName(PATH_COMMENT) @set:PropertyName(PATH_COMMENT) var comment: String = "",
                   @get:PropertyName(PATH_DEVICE_ID) @set:PropertyName(PATH_DEVICE_ID) var deviceId: String = "",
                   @get:PropertyName(PATH_DATE) @set:PropertyName(PATH_DATE) var date: Long = 0,
                   @get:PropertyName(PATH_COUNT_UP) @set:PropertyName(PATH_COUNT_UP) var countUp: Int = 0,
                   @get:PropertyName(PATH_COUNT_DOWN) @set:PropertyName(PATH_COUNT_DOWN) var countDown: Int = 0)