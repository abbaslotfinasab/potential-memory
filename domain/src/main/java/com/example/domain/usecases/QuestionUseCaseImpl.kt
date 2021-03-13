package com.example.domain.usecases

import com.example.domain.models.QuestionModel
import com.example.domain.repositories.QuestionRepo
import javax.inject.Inject


class QuestionUseCaseImpl @Inject constructor(private val questionRepo: QuestionRepo):
    QuestionUseCase<QuestionModel>{
    override suspend fun execute():List<QuestionModel> {
       return questionRepo.getQuestion()
    }

}