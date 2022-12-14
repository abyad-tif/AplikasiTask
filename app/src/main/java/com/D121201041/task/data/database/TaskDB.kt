package com.D121201041.task.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.D121201041.task.data.database.dao.TaskDao
import com.D121201041.task.data.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDB: RoomDatabase() {

    abstract fun task(): TaskDao

    companion object {
        @Volatile

        private var INSTANCE: TaskDB? = null

        fun getDatabase(context: Context): TaskDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDB::class.java,
                    "task_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}