package com.example.data.di


import com.example.data.repo.QuestionRepoImpl
import com.example.domain.repositories.QuestionRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {
    @Binds
    abstract fun bindAnalyticsService(
            analyticsServiceImpl: QuestionRepoImpl
    ):  QuestionRepo
}
