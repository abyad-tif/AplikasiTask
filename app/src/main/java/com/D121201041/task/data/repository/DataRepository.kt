package com.D121201041.task.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.D121201041.task.data.model.Task

class DataRepository(context: Context): Repository {

    private val localRepository = LocalRepository(context)

    override fun getTask(state: MutableLiveData<List<Task>>) {
        localRepository.getTask(state)
    }

    override fun addTask(data: Task) {
        localRepository.addTask(data)
    }
}