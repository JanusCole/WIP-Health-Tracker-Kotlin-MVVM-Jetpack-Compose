package com.januscole.achieve.di

import com.januscole.achieve.data.source.activities.HealthyActivitiesRepository
import com.januscole.achieve.data.source.activities.HealthyActivitiesRepositoryImpl
import com.januscole.achieve.data.source.activities.HealthyActivitiesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HealthyActivitiesRepositoryModule {
    @Singleton
    @Provides
    fun provideHealthyActivitiesRepository(
        healthyActivitiesService: HealthyActivitiesService
    ): HealthyActivitiesRepository {
        return HealthyActivitiesRepositoryImpl(healthyActivitiesService)
    }
}