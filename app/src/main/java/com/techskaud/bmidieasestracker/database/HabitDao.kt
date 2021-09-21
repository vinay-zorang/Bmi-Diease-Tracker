package com.techskaud.bmidieasestracker.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.federicocotogno.habittracker2020.data.models.Habit
@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHabit(habit: Habit)

    @Query("SELECT * FROM habit_table ORDER BY id DESC")
    fun getAllHabits(): LiveData<List<Habit>>

    @Query("SELECT * FROM habit_table where date=:date")
    fun getHabitByDate(date:String):Habit

}