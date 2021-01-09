package com.example.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question (

    @SerializedName("id")
    @Expose
    var id:Int?=0,

    @SerializedName("first")
    @Expose
    var first:String?=null,

    @SerializedName("second")
    @Expose
    var second:String?=null,

):Parcelable
