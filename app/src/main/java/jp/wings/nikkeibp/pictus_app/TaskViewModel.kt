package jp.wings.nikkeibp.pictus_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import jp.wings.nikkeibp.pictus_app.data.task.MyTasks
import jp.wings.nikkeibp.pictus_app.data.task.MyTasksDatabase
import jp.wings.nikkeibp.pictus_app.repository.MyTasksRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel (application: Application) : AndroidViewModel(application) {
    private val dao = MyTasksDatabase
        .getMyTasksDatabase(application)
        .myTasksDao()

    private val repository = MyTasksRepository(dao)

    val allTasks = repository.allTasks
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addTask(task: MyTasks) = viewModelScope.launch {
        repository.insert(task)
    }

    fun deleteTask(task: MyTasks) = viewModelScope.launch {
        repository.delete(task)
    }
}