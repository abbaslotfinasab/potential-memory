package com.example.domain.repositories

import com.example.domain.models.QuestionModel
import io.reactivex.rxjava3.core.Single

interface QuestionRepo {

    fun getQuestion(): Single<QuestionModel>
}