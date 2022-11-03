package com.januscole.achieve.data.source.activities

import com.januscole.achieve.data.model.ActivityStatus
import com.januscole.achieve.data.model.HealthyActivity
import java.util.*

object HealthyActivitiesRepositoryObject : HealthyActivitiesRepository {

    private val healthyActivitiesService = MockHealthyActivitiesService()
    var healthyActivities: MutableList<HealthyActivity> = mutableListOf()

    init {
        refreshActivities()
    }

    override fun getAllActivities(): List<HealthyActivity> {
        return healthyActivities
    }

    override fun getActiveActivities(): List<HealthyActivity> {
        return healthyActivities.filter {
            it.status.equals(ActivityStatus.ACTIVE)
        }
    }

    override fun getCompletedActivities(): List<HealthyActivity> {
        return healthyActivities.filter {
            it.status.equals(ActivityStatus.COMPLETED)
        }
    }

    override fun completeActivity(activityId: UUID) {
        healthyActivitiesService.completeHealthyActivity(activityId)
        refreshActivities()
    }

    private fun refreshActivities() {
        healthyActivities = healthyActivitiesService.getHealthyActivities().toMutableList()
    }
}