package com.januscole.achieve.data.source.calories

import android.util.Log
import org.junit.Before
import org.junit.Test
import java.time.LocalDate


internal class CaloriesRepositoryImplTest {

    lateinit var caloriesRepository: CaloriesRepositoryImpl

    @Before
    fun setup() {
        caloriesRepository = CaloriesRepositoryImpl(MockCaloriesDataSource())
    }

    @Test
    fun getCalories() {
        caloriesRepository.calories.forEach {
            println("XXXXXX" + "BEFORE " + it.date + " " + it.calories)
        }
        caloriesRepository.getCalories(LocalDate.now())
        caloriesRepository.calories.forEach {
            println("XXXXXX" + "AFTER " + it.date + " " + it.calories)
        }
        caloriesRepository.updateCalories(LocalDate.now(), 99999)
        println("XXXXXX" + "AFTER UPDATE TO 99999 " + caloriesRepository.getCalories(LocalDate.now()))
        caloriesRepository.updateCalories(LocalDate.now().minusDays(7), 88888)
        println("XXXXXX" + "AFTER UPDATE TO 88888 " + caloriesRepository.getCalories(LocalDate.now().minusDays(7)))
        caloriesRepository.getCaloriesSince(LocalDate.now().minusDays(10)).forEach {
            println("XXXXXX" + "AFTER " + it.date + " " + it.calories)
        }
    }

    @Test
    fun getCaloriesSince() {
    }

    @Test
    fun updateCalories() {
    }
}