package jp.wings.nikkeibp.pictus_app.data.task

import jp.wings.nikkeibp.pictus_app.repository.MyTasksRepository
import android.content.Context

class MyTasksContainer(private val context: Context) {
    val myTasksRepository: MyTasksRepository by lazy {
        MyTasksRepository(MyTasksDatabase.getMyTasksDatabase(context).myTasksDao())
    }
}