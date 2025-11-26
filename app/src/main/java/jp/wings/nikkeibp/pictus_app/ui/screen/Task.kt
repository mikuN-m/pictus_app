package jp.wings.nikkeibp.pictus_app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.AppPage
import jp.wings.nikkeibp.pictus_app.TaskViewModel
import jp.wings.nikkeibp.pictus_app.ui.components.NavigationContent
import jp.wings.nikkeibp.pictus_app.ui.components.TaskItem

@Composable
fun Task (
    navController: NavHostController,
    viewModel: TaskViewModel,
    modifier: Modifier = Modifier
) {
    val taskList by viewModel.allTasks.collectAsState(initial = emptyList())
    var taskMsg = ""
    taskMsg = if (taskList.isEmpty()) {
        "タスクがありません"
    } else {
        ""
    }


    Box {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                if (taskList.isEmpty()) {
                    Text(taskMsg)
                } else {
                    LazyColumn {
                        items(taskList) { task ->
                            TaskItem(task = task)
                        }
                    }
                }
            }

            Button(onClick = {navController.navigate(AppPage.TaskAdd.name)}) {
                Text("タスクを追加")
            }
        }

        NavigationContent(navController = navController)
    }
}