package com.techskaud.bmidieasestracker.repository

import androidx.lifecycle.LiveData
import com.federicocotogno.habittracker2020.data.models.Habit
import com.techskaud.bmidieasestracker.database.HabitDao

class HabitRepository (private val habitDao: HabitDao) {

    val getAllHabits: LiveData<List<Habit>> = habitDao.getAllHabits()

    suspend fun addHabit(habit: Habit) {
        habitDao.addHabit(habit)
    }
     fun getHabit(date: String) {
        habitDao.getHabitByDate(date)
    }

}