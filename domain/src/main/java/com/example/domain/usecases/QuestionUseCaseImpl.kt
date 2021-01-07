package com.example.domain.usecases

import com.example.domain.models.QuestionModel
import com.example.domain.repositories.QuestionRepo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuestionUseCaseImpl @Inject constructor(private val questionRepo: QuestionRepo):

    QuestionUseCase<QuestionModel>{
    override fun execute(): Single<QuestionModel> {
       return questionRepo.getQuestion()
    }

}