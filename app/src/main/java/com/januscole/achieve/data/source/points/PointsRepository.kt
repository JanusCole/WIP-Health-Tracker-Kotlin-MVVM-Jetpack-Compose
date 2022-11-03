package com.januscole.achieve.data.source.points

interface PointsRepository {
    fun getPoints(): Int
    fun setPoints(newPoints: Int)
}