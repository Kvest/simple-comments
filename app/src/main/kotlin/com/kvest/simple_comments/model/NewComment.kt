package com.kvest.simple_comments.model

import com.google.firebase.database.PropertyName
import com.kvest.simple_comments.data.PATH_COMMENT
import com.kvest.simple_comments.data.PATH_DEVICE_ID

/**
 * Created by robielok on 1/26/2018.
 */
data class NewComment(@PropertyName(PATH_COMMENT) var comment: String,
                      @PropertyName(PATH_DEVICE_ID) var deviceId: String)