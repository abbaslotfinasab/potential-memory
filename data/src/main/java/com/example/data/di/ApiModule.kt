package com.example.data.di

import com.example.data.api.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@InstallIn(ApplicationComponent::class)
@Module(includes=[NetworkModule::class])
class ApiModule {

    @Provides
    fun bindApiService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

}