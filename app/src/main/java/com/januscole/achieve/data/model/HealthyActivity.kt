package com.januscole.achieve.data.model

import java.time.LocalDate
import java.util.*

data class HealthyActivity(
    val activityId: UUID,
    var type: ActivityType,
    val title: String,
    val description: String,
    val expirationDate: LocalDate,
    var dateCompleted: LocalDate?,
    val points: Int,
    var status: ActivityStatus
)