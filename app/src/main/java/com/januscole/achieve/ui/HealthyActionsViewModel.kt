package com.januscole.achieve.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.januscole.achieve.data.model.ActivityStatus
import com.januscole.achieve.data.model.HealthyActivity
import com.januscole.achieve.data.source.activities.HealthyActivitiesRepositoryObject
import com.januscole.achieve.data.source.points.PointsRepositoryObject
import java.util.*

class HealthyActionsViewModel: ViewModel() {

    private val _healthyActivities: MutableState<List<HealthyActivity>> = mutableStateOf(listOf())

    private val _completedActivities: MutableState<List<HealthyActivity>> = mutableStateOf(listOf())

    private val _activeActivities: MutableState<List<HealthyActivity>> = mutableStateOf(listOf())

    private var _points: MutableState<Int> = mutableStateOf(0)

    private val activitiesRepository = HealthyActivitiesRepositoryObject

    private val pointsRepository = PointsRepositoryObject

    init {
        refreshActivities()
    }

    private fun refreshActivities() {
        _healthyActivities.value = activitiesRepository.getAllActivities()
        _completedActivities.value = _healthyActivities.value.filter {
            it.status.equals(ActivityStatus.COMPLETED)
        }
        _activeActivities.value = _healthyActivities.value.filter {
            it.status.equals(ActivityStatus.ACTIVE)
        }
        _points.value = 0
        _completedActivities.value.forEach {
            _points.value = _points.value + it.points
        }
    }

    fun getHealthyActivitiesList():  MutableState<List<HealthyActivity>> = _healthyActivities

    fun getActiveHealthyActivitiesList():  MutableState<List<HealthyActivity>> = _activeActivities

    fun getCompletedHealthyActivitiesList():  MutableState<List<HealthyActivity>> = _completedActivities

    fun getCompletedPoints():  MutableState<Int> = _points

    fun completeActivity(activityId: UUID) {
        _healthyActivities.value.forEach {
            if (it.activityId == activityId) {
                pointsRepository.setPoints(it.points)
            }
        }
        activitiesRepository.completeActivity(activityId)
        refreshActivities()
    }

}