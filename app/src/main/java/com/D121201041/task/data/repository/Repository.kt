package com.D121201041.task.data.repository

import androidx.lifecycle.MutableLiveData
import com.D121201041.task.data.model.Task

interface Repository {
    fun getTask(state: MutableLiveData<List<Task>>)
    fun addTask(data: Task)
}