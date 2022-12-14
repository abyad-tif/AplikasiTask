package com.D121201041.task.data.database.dao

import androidx.room.*
import com.D121201041.task.data.model.Task
import io.reactivex.Single

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(data: Task): Single<Long>

    @Query("SELECT * FROM task ORDER BY id ASC")
    suspend fun get():List<Task>

}