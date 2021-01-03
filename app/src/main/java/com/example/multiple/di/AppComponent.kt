package com.example.multiple.di

import com.example.data.di.ApiModule
import com.example.data.di.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(
    subcomponents = [
        NetworkModule::class,
        ApiModule::class
    ]
)
class AppComponent