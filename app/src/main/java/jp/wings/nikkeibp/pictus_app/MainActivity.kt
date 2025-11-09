package jp.wings.nikkeibp.pictus_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.wings.nikkeibp.pictus_app.data.MyTasksDao
import jp.wings.nikkeibp.pictus_app.data.MyTasksDataBase
import jp.wings.nikkeibp.pictus_app.ui.theme.Pictus_appTheme
import java.nio.file.WatchEvent
import kotlin.getValue

enum class AppPage {
    Home,
    Task,
    Record,
    MyPage
}

class MainActivity : ComponentActivity() {
    val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Pictus_appTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = AppPage.Home.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        //ホーム画面
                        composable (route = AppPage.Home.name) {
                            HomeScreen(navController = navController)
                        }
                        composable (route = AppPage.Task.name) {
                            TaskScreen(navController = navController,taskViewModel)
                        }
                        composable (route = AppPage.Record.name) {
                            RecordScreen(navController = navController)
                        }
                        composable (route = AppPage.MyPage.name) {
                            MyPage(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen (navController: NavHostController, modifier: Modifier = Modifier) {
    Box {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "homeですよ",
                modifier = Modifier
            )
        }

        NavigationContent(navController = navController)
    }
}

@Composable
fun TaskScreen (navController: NavHostController, viewModel: TaskViewModel,modifier: Modifier = Modifier) {
    val taskList by viewModel.allTasks.collectAsState(initial = emptyList())

    Box {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "task"
            )
        }

        NavigationContent(navController = navController)
    }
}

@Composable
fun RecordScreen (navController: NavHostController,modifier: Modifier = Modifier) {
    Box {
        NavigationContent(navController = navController)
    }
}

@Composable
fun MyPage (navController: NavHostController, modifier: Modifier = Modifier) {
    Box {
        NavigationContent(navController = navController)
    }
}

@Composable
fun NavigationContent (navController: NavHostController,modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {navController.navigate(AppPage.Home.name)}) {
            Text("ホーム")
        }
        Button(onClick = {navController.navigate(AppPage.Task.name)}) {
            Text("タスク")
        }
        Button(onClick = {navController.navigate(AppPage.Record.name)}) {
            Text("記録")
        }
        Button(onClick = {navController.navigate(AppPage.MyPage.name)}) {
            Text("マイページ")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pictus_appTheme {
        val navController = rememberNavController()

        // テスト用のタスクページと本番用のタスクページを使い分ける
        HomeScreen(navController)
    }
}