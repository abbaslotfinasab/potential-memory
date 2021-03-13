package com.example.domain.repositories

import com.example.domain.models.QuestionModel


interface QuestionRepo{

     suspend fun getQuestion():List<QuestionModel>

}