package com.januscole.achieve.data.source.calories

import com.januscole.achieve.data.model.Calories
import java.time.LocalDate

interface CaloriesDataSource {
    fun getAllCalories(): List<Calories>
    fun AddCalories(date: LocalDate, newCalories: Int)
    fun updateCalories(date: LocalDate, newCalories: Int)
}