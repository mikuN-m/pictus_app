package jp.wings.nikkeibp.pictus_app

import androidx.compose.runtime.mutableStateListOf
import jp.wings.nikkeibp.pictus_app.data.MyTasks

class FakeTaskViewModel {
    val fakeTasks = mutableStateListOf(
        MyTasks(1, "勉強"),
        MyTasks(2, "買い物")
    )

    fun addFakeTask() {
        fakeTasks.add(MyTasks(name = "fakeTask"))
    }
}