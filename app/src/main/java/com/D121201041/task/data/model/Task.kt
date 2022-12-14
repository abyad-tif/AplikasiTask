package com.D121201041.task.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val content: String,
    val category: String
)