package jp.wings.nikkeibp.pictus_app

import android.app.Application
import jp.wings.nikkeibp.pictus_app.data.task.MyTasksContainer

class MyTasksApplication: Application() {
    lateinit var container: MyTasksContainer
    override fun onCreate() {
        super.onCreate()
        container = MyTasksContainer(this)
    }
}