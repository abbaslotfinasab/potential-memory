package com.example.multiple.di

import android.app.Application
import android.content.Context
import com.example.multiple.rx.SchedulersFacade
import com.example.multiple.rx.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulersProvider
}