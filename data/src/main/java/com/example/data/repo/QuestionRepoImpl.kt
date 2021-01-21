package com.example.data.repo

import com.example.data.api.Service
import com.example.data.mapper.QuestionMapper
import com.example.domain.models.QuestionModel
import com.example.domain.repositories.QuestionRepo
import io.reactivex.rxjava3.core.Single
import java.io.IOException
import javax.inject.Inject
import kotlin.jvm.Throws

class QuestionRepoImpl @Inject constructor(

    private val questionMapper: dagger.Lazy<QuestionMapper>,
    private val service:Service

):QuestionRepo {

    @Throws(IOException::class)

    override fun getQuestion(): Single<QuestionModel> {

        return if (service.getQuestion().blockingGet().isSuccessful && service.getQuestion().blockingGet().body()!=null) {

            service.getQuestion().map {

                it.body()?.let { it1 -> questionMapper.get().toMapper(it1) }
            }

        }

        else
            throw IOException ("Server is Not Responding")
    }
}

