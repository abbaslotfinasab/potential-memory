package com.example.data.api

import com.example.data.entity.Question
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("/get_question")

    suspend fun getQuestion():Response<List<Question>>

}