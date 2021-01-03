package com.example.data.mapper

import com.example.data.entity.Question
import com.example.domain.models.QuestionModel
import javax.inject.Inject

class QuestionMapper @Inject constructor() {
    fun toMapper (question:Question):QuestionModel{

        return QuestionModel(

        question.id?:0,

        question.first?:"",

        question.secend?:""
        )
    }
}