package com.example.data.repo

import com.example.data.api.Service
import com.example.data.mapper.QuestionMapper
import com.example.data.util.NetworkHelper
import com.example.domain.models.QuestionModel
import com.example.domain.repositories.QuestionRepo
import java.io.IOException
import javax.inject.Inject
import kotlin.jvm.Throws

class QuestionRepoImpl @Inject constructor(

    private val questionMapper: dagger.Lazy<QuestionMapper>,
    private val service:Service,
    private val networkHelper: NetworkHelper

):QuestionRepo {

    @Throws(IOException::class)

    override suspend fun getQuestion(): List<QuestionModel> {

        if (networkHelper.isNetworkConnected()) {

            return if (service.getQuestion().isSuccessful && service.getQuestion().body() != null) {

                service.getQuestion().body()!!.map {

                    questionMapper.get().toMapper(it)
                }

            } else
                throw IOException("Sever is Not Responding")

        } else
            throw IOException("No Internet Connection")
    }

}


