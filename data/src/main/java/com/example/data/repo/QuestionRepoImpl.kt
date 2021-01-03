package com.example.data.repo

import com.example.data.api.Service
import com.example.data.mapper.QuestionMapper
import com.example.domain.models.QuestionModel
import com.example.domain.repositories.QuestionRepo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuestionRepoImpl @Inject constructor(
    private val questionMapper: dagger.Lazy<QuestionMapper>,
    private val service: Service
):QuestionRepo {
    override fun getQuestion(): Single<QuestionModel> {
        return service.getQuestion().map {
            questionMapper.get().toMapper(it)
        }
    }

}