package com.januscole.achieve.data.source.activities

import com.januscole.achieve.data.model.HealthyActivity
import java.util.*

interface HealthyActivitiesRepository {

    fun getAllActivities(): List<HealthyActivity>
    fun getActiveActivities(): List<HealthyActivity>
    fun getCompletedActivities(): List<HealthyActivity>
    fun completeActivity(activityId: UUID)
}