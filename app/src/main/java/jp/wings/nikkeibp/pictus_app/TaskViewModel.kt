package jp.wings.nikkeibp.pictus_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import jp.wings.nikkeibp.pictus_app.data.MyTasks
import jp.wings.nikkeibp.pictus_app.data.MyTasksDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel (application: Application): AndroidViewModel(application) {
    private val dao = MyTasksDataBase.getMyTasksDatabase(application).MyTasksDao()

    val allTasks: Flow<List<MyTasks>> = dao.getAll()

    fun addTask(task: MyTasks) {
        viewModelScope.launch {
            dao.insertTask(task)
        }
    }
}