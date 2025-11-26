package jp.wings.nikkeibp.pictus_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.wings.nikkeibp.pictus_app.ui.screen.Home
import jp.wings.nikkeibp.pictus_app.ui.screen.MyPage
import jp.wings.nikkeibp.pictus_app.ui.screen.Record
import jp.wings.nikkeibp.pictus_app.ui.screen.Task
import jp.wings.nikkeibp.pictus_app.ui.screen.TaskAdd
import jp.wings.nikkeibp.pictus_app.ui.theme.Pictus_appTheme
import kotlin.getValue

enum class AppPage {
    Home,
    Task,
    Record,
    MyPage,
    TaskAdd,
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
                            Home(navController = navController)
                        }
                        composable (route = AppPage.Task.name) {
                            Task(
                                navController = navController,
                                viewModel = taskViewModel
                            )
                        }
                        composable (route = AppPage.Record.name) {
                            Record(navController = navController)
                        }
                        composable (route = AppPage.MyPage.name) {
                            MyPage(navController = navController)
                        }
                        composable (route = AppPage.TaskAdd.name) {
                            TaskAdd(
                                navController = navController,
                                viewModel = taskViewModel,
                                onSaved = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pictus_appTheme {
        val navController = rememberNavController()

        // テスト用のタスクページと本番用のタスクページを使い分ける
        Home(navController)
    }
}