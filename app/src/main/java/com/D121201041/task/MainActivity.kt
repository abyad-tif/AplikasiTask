package com.D121201041.task

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.D121201041.task.data.database.TaskDB
import com.D121201041.task.databinding.ActivityMainBinding
import com.D121201041.task.ui.link.TaskAdapter
import com.D121201041.task.ui.link.TaskViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    val db by lazy { TaskDB(this) }
    lateinit var taskAdapter: TaskAdapter

    private val viewModel: TaskViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[TaskViewModel::class.java]
    }


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val task = db.task().get()
            Log.d("MainActivity", "Respon: $task")
            withContext(Dispatchers.Main) {
                taskAdapter.setData(task)
            }
        }
    }

    private fun setupListener() {
        button_create.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(arrayListOf())
        list_task.apply {
            LayoutManager = LinearLayoutManager(applicationContext)
            adapter = taskAdapter
        }
    }
}