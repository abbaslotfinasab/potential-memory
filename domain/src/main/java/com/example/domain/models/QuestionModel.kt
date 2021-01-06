package com.example.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionModel(

    var id:Int?,
    var first:String?,
    var second:String?

):Parcelable
