package com.januscole.achieve.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.januscole.achieve.data.source.activities.HealthyActivitiesRepositoryObject
import com.januscole.achieve.data.source.points.PointsRepositoryObject

class PointsViewModel: ViewModel() {

    private val activitiesRepository = HealthyActivitiesRepositoryObject

    private val _amountOwed: MutableState<Float> = mutableStateOf(17.50F)
    fun getAmountOwed() = _amountOwed

    private var _points: MutableState<Int> = mutableStateOf(0)
    fun getPoints() = _points

    init {

    }

}