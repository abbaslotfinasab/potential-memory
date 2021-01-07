package com.example.data.di

import com.example.data.api.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes=[NetworkModule::class])
@InstallIn(ApplicationComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun bindApiService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

}