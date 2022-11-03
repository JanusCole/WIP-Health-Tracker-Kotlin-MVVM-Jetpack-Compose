package com.januscole.achieve.data.source.activities

import com.januscole.achieve.data.model.HealthyActivity
import java.util.*

interface HealthyActivitiesService {
    fun getHealthyActivities(): List<HealthyActivity>
    fun completeHealthyActivity(activityId: UUID)
}