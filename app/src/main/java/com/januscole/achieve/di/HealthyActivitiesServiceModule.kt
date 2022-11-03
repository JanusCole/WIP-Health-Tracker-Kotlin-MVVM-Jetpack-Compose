package com.januscole.achieve.di

import com.januscole.achieve.data.source.activities.HealthyActivitiesService
import com.januscole.achieve.data.source.activities.MockHealthyActivitiesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HealthyActivitiesServiceModule {
    @Singleton
    @Provides
    fun provideHealthyActivitiesService(): HealthyActivitiesService {
        return MockHealthyActivitiesService()
    }
}