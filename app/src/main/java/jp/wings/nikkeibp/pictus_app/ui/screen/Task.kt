package jp.wings.nikkeibp.pictus_app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.TaskViewModel
import jp.wings.nikkeibp.pictus_app.ui.components.NavigationContent

@Composable
fun Task (navController: NavHostController, viewModel: TaskViewModel,modifier: Modifier = Modifier) {
    val taskList by viewModel.allTasks.collectAsState(initial = emptyList())
    var taskMsg = ""
    if (taskList.isEmpty()) {
        taskMsg = "タスクがありません"
    }

    Box {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = taskMsg
            )

            Button(onClick = {navController.navigate("home")}) {
                Text("ホームに戻る")
            }
        }

        NavigationContent(navController = navController)
    }
}