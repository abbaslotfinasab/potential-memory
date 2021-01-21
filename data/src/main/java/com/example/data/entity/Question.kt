package com.example.data.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Question (

  @Json(name="id")
    var id:Int?=0,

  @Json(name="first")
    var first:String?=null,

  @Json(name="second")
    var second:String?=null,

):Parcelable
