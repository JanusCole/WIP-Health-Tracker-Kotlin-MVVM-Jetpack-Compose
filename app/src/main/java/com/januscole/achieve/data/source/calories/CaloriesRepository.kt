package com.januscole.achieve.data.source.calories

import com.januscole.achieve.data.model.Calories
import java.time.LocalDate

interface CaloriesRepository {
    fun getCalories(date: LocalDate): Int
    fun getCaloriesSince(date: LocalDate): List<Calories>
    fun getAllCalories(): List<Calories>
    fun updateCalories(date: LocalDate, newCalories: Int)
}