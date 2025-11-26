package jp.wings.nikkeibp.pictus_app.repository

import jp.wings.nikkeibp.pictus_app.data.task.MyTasks
import jp.wings.nikkeibp.pictus_app.data.task.MyTasksDao
import kotlinx.coroutines.flow.Flow

class MyTasksRepository(private val myTasksDao: MyTasksDao) {
    val allTasks: Flow<List<MyTasks>> = myTasksDao.getAll()

    // suspend関数 → Daoのやつを呼ぶだけ
    suspend fun insert(task: MyTasks) {
        myTasksDao.insertTask(task)
    }

    suspend fun delete(task: MyTasks) {
        myTasksDao.deleteAllMyTasks(listOf(task))
    }
}