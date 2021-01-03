package com.example.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Question (

    @SerializedName("id")
    @Expose
    var id:Int?=0,

    @SerializedName("actor")
    @Expose
    var first:String?=null,

    @SerializedName("role")
    @Expose
    var secend:String?=null,

)
