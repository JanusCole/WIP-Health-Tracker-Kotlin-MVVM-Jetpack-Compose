package com.januscole.achieve.data.source.activities

import android.util.Log
import com.januscole.achieve.data.model.ActivityStatus
import com.januscole.achieve.data.model.ActivityType
import com.januscole.achieve.data.model.HealthyActivity
import java.time.LocalDate
import java.util.*

class MockHealthyActivitiesService : HealthyActivitiesService {
    var healthyActivitiesList: MutableList<HealthyActivity> = mutableListOf()

    init {
        healthyActivitiesList = generateMockData()
    }

    override fun getHealthyActivities(): List<HealthyActivity> {
        return healthyActivitiesList
    }

    fun generateMockData(): MutableList<HealthyActivity> {
        return mutableListOf(
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Challenge: Go for a walk",
                """This week, we're going to start small. Your goal is to take three brisk , 10-minute walks anytime before Saturday. And we'll share some
some tips on proper walking along the way. Be sure to track your walks on your Apple Watch tgo get credit.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                null,
                50,
                ActivityStatus.ACTIVE
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Sleep - Any exercise, any way you like",
                """Wondering if your favorite exercise is good for sleep? You're in luck, because science says it's all good. Walking, running, weight training, even Jazzercise. Just getting
it done can help you get better sleep.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                null,
                25,
                ActivityStatus.ACTIVE
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Get your flu shot",
                """It's that time of year again. Now more than ever, it's important to protect yourself from the flu. Help reduce your risk and keep yourself safer by getting your
flu shot. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                null,
                75,
                ActivityStatus.ACTIVE
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Refill your prescription",
                """It's time to refill your prescription again. Stop by your local CVS to have your prescription filled by a professional pharmacist.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                null,
                125,
                ActivityStatus.ACTIVE
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Schedule your annual physical",
                """It's that time of year again. Now more than ever, it's important to schedule your physical. Help reduce your risk and keep yourself safer by getting your physical. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                null,
                100,
                ActivityStatus.ACTIVE
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.CALORIE_GOAL,
                "Daily Calorie Goal",
                """It's that time of year again. Now more than ever, it's important to schedule your physical. Help reduce your risk and keep yourself safer by getting your physical. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                100,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Challenge: Go for a walk",
                """This week, we're going to start small. Your goal is to take three brisk , 10-minute walks anytime before Saturday. And we'll share some
some tips on proper walking along the way. Be sure to track your walks on your Apple Watch tgo get credit.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                50,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Sleep - Any exercise, any way you like",
                """Wondering if your favorite exercise is good for sleep? You're in luck, because science says it's all good. Walking, running, weight training, even Jazzercise. Just getting
it done can help you get better sleep.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                25,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Get your flu shot",
                """It's that time of year again. Now more than ever, it's important to protect yourself from the flu. Help reduce your risk and keep yourself safer by getting your
flu shot. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                75,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Refill your prescription",
                """It's time to refill your prescription again. Stop by your local CVS to have your prescription filled by a professional pharmacist.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                125,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.HEALTHY_ACTIVITY,
                "Schedule your annual physical",
                """It's that time of year again. Now more than ever, it's important to schedule your physical. Help reduce your risk and keep yourself safer by getting your physical. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                100,
                ActivityStatus.COMPLETED
            ),
            HealthyActivity(
                UUID.randomUUID(),
                ActivityType.CALORIE_GOAL,
                "Daily Calorie Goal",
                """It's that time of year again. Now more than ever, it's important to schedule your physical. Help reduce your risk and keep yourself safer by getting your physical. It's free through most insurance plans.""",
                LocalDate.now().plusDays((Random().nextInt(7) + 1).toLong()),
                LocalDate.now().minusDays((Random().nextInt(7) + 1).toLong()),
                100,
                ActivityStatus.COMPLETED
            )
        )
    }

    override fun completeHealthyActivity(activityId: UUID) {
        Log.d("XXXXX", "COMPLETE ACTIVITY" + activityId.toString())
        healthyActivitiesList.forEach {
            if (it.activityId == activityId) {
                Log.d("XXXXX", "COMPLETING ACTIVITY" + activityId.toString())
                it.status = ActivityStatus.COMPLETED
                it.dateCompleted = LocalDate.now()
            }
        }
    }
}