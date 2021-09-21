package com.techskaud.bmidieasestracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.federicocotogno.habittracker2020.data.models.Habit
import com.techskaud.bmidieasestracker.database.HabitDatabase
import com.techskaud.bmidieasestracker.repository.HabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    val getAllHabits: LiveData<List<Habit>>


    init {
        val habitDao= HabitDatabase.getDatabase(application).habitDao()
        repository = HabitRepository(habitDao)

        getAllHabits = repository.getAllHabits
    }

    fun addHabit(habit: Habit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHabit(habit)
        }
    }

    fun getHabit(date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getHabit(date)
        }
    }




}