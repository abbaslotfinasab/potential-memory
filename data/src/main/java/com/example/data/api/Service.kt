package com.example.data.api

import com.example.data.entity.Question
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Service {

    @GET("/question")
    fun getQuestion(): Single<Question>
}