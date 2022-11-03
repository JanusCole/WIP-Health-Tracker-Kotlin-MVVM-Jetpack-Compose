package com.januscole.achieve.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.januscole.achieve.data.model.HealthyActivity
import com.januscole.achieve.data.source.activities.HealthyActivitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class HealthyActivitiesViewModel @Inject constructor(private val healthyActivitiesRepository: HealthyActivitiesRepository): ViewModel() {

    private var _healthyActivities: MutableState<List<HealthyActivity>> = mutableStateOf(
        listOf()
    )

    init {

    }

    fun getHealthyActivitiesList():  MutableState<List<HealthyActivity>> = _healthyActivities

    fun completeActivity(activityId: UUID) {}

}