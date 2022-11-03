package com.januscole.achieve.data.source.points

import com.januscole.achieve.data.source.points.PointsRepository

class PointsRepositoryImpl : PointsRepository {

    var userPoints: Int = 0

    override fun getPoints(): Int {
        return userPoints
    }

    override fun setPoints(newPoints: Int) {
        userPoints = newPoints
    }
}