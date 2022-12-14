package com.D121201041.task.ui.link

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.D121201041.task.R
import com.D121201041.task.data.model.Task
import io.reactivex.Single

class TaskAdapter(private val tasks: ArrayList<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.view.add_task.text = task.content
        holder.view.add_category.text = task.category
    }

    override fun getItemCount() = tasks.size

    class TaskViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun setData(list: List<Task>){
        tasks.clear()
        tasks.addAll(list)
        notifyDataSetChanged()
    }
}