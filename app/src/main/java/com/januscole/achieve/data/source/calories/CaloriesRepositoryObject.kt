package com.januscole.achieve.data.source.calories

import com.januscole.achieve.data.model.Calories
import java.time.LocalDate
import java.util.*
import kotlin.NoSuchElementException

object CaloriesRepositoryObject : CaloriesRepository {

    private val dataSource: CaloriesDataSource = MockCaloriesDataSource()

    var calories: MutableList<Calories> = mutableListOf()

    init {
        getAllCalories()
    }

    private fun refreshAllCalories() {
        calories = dataSource.getAllCalories().sortedBy {
            it.date
        }.toMutableList()
    }

    override fun getCalories(date: LocalDate): Int {
        return try {
            calories.filter { it ->
                it.date.equals(date)
            }.first().calories
        } catch (e: NoSuchElementException) {
            dataSource.AddCalories(date, 0)
            refreshAllCalories()
            0
        }
    }

    override fun getCaloriesSince(date: LocalDate): List<Calories> {
        return calories.filter { it ->
            it.date.isAfter(date)
        }
    }

    override fun getAllCalories(): List<Calories> {
        return calories
    }

    override fun updateCalories(date: LocalDate, newCalories: Int) {
        dataSource.updateCalories(date, newCalories)
        refreshAllCalories()
    }
}