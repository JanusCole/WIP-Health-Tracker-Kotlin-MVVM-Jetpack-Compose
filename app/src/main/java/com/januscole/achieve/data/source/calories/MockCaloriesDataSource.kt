package com.januscole.achieve.data.source.calories

import com.januscole.achieve.DAILY_CALORIE_GOAL
import com.januscole.achieve.data.model.Calories
import java.time.LocalDate
import java.util.*

class MockCaloriesDataSource : CaloriesDataSource {

    val calories: MutableList<Calories> = mutableListOf()

    init {
        (1..100).forEach {
            calories.add(Calories(Random().nextInt(DAILY_CALORIE_GOAL), LocalDate.now().minusDays(it.toLong())))
        }
    }

    override fun getAllCalories(): List<Calories> = calories

    override fun AddCalories(date: LocalDate, newCalories: Int) {
        calories.add(Calories(newCalories, date))
    }

    override fun updateCalories(date: LocalDate, newCalories: Int) {
        calories.forEach {
            if (it.date.equals(date)) {
                it.calories = newCalories
            }
        }
    }
}