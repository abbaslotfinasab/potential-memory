package com.example.domain.usecases


import io.reactivex.rxjava3.core.Single

interface QuestionUseCase<R> {

     fun execute():Single<R>

}