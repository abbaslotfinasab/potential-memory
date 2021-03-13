package com.example.domain.usecases


interface QuestionUseCase<R> {

     suspend fun execute():List<R>

}