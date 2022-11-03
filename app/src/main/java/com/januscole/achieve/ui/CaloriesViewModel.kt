package com.januscole.achieve.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.januscole.achieve.data.model.Calories
import com.januscole.achieve.data.source.calories.CaloriesRepositoryImpl
import com.januscole.achieve.data.source.calories.CaloriesRepositoryObject
import com.januscole.achieve.data.source.calories.MockCaloriesDataSource
import java.time.LocalDate

class CaloriesViewModel: ViewModel() {

    private val _currentDailyCalories: MutableState<Int> = mutableStateOf(0)
    private val _priorWeekCalorieGoals: MutableState<List<Calories>> = mutableStateOf(listOf())
    private val _allCalorieGoals: MutableState<List<Calories>> = mutableStateOf(listOf())

    private val repository = CaloriesRepositoryObject

    init {
        refreshCurrentDailyCalories()
    }

    private fun refreshCurrentDailyCalories() {
        _currentDailyCalories.value = repository.getCalories(LocalDate.now())
        _allCalorieGoals.value = repository.getAllCalories()
        _priorWeekCalorieGoals.value = getCaloriesSince(LocalDate.now().minusDays(7))
    }

    private fun getCaloriesSince(date: LocalDate): List<Calories> {
        return _allCalorieGoals.value.filter { it ->
            it.date.isAfter(date)
        }
    }

    fun getCurrentDailyCalories():  MutableState<Int> = _currentDailyCalories
    fun getWeeklyCalories():  MutableState<List<Calories>> = _priorWeekCalorieGoals
    fun getAllDailyCalories():  MutableState<List<Calories>> = _allCalorieGoals

    fun updateCalories(date: LocalDate, newCalories: Int) {
        repository.updateCalories(date, newCalories)
        refreshCurrentDailyCalories()
    }

}