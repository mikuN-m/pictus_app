package jp.wings.nikkeibp.pictus_app.data

import MyTasksRepository
import android.content.Context

class MyTasksContainer(private val context: Context) {
    val myTasksRepository: MyTasksRepository by lazy {
        MyTasksRepository(MyTasksDataBase.getMyTasksDatabase(context).MyTasksDao())
    }
}