package com.example.data.di


import com.example.data.repo.QuestionRepoImpl
import com.example.domain.repositories.QuestionRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepositoryService(
            questionRepoImpl: QuestionRepoImpl
    ):  QuestionRepo
}
