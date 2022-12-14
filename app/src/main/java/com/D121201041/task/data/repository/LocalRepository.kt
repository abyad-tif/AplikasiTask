package com.D121201041.task.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.D121201041.task.data.database.TaskDB
import com.D121201041.task.data.model.Task
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LocalRepository(context: Context): Repository {

    private val db:TaskDB = TaskDB.getDatabase(context)
    private val disposable = CompositeDisposable()

    override fun getTask(state: MutableLiveData<List<Task>>) {
        db.task().get()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable()
            .subscribe(state::postValue)
            .let(disposable::add)
    }

    override fun addTask(data: Task) {
        db.task().insert(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable()
            .subscribe()
            .let(disposable::add)
    }
}