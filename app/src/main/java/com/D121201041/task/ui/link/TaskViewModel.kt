package com.D121201041.task.ui.link

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.D121201041.task.data.model.Task
import com.D121201041.task.data.repository.DataRepository
import kotlinx.coroutines.*

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val repository = DataRepository(application)

    val getState : MutableLiveData<List<Task>> by lazy {
        MutableLiveData<List<Task>>()
    }

    val addState : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getData() {
        repository.getTask(getState)
    }

    fun addData(data: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addTask(data)
            withContext(Dispatchers.IO){
                addState.postValue(true)
            }
        }
    }

}