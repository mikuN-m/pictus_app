package jp.wings.nikkeibp.pictus_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.wings.nikkeibp.pictus_app.ui.theme.Pictus_appTheme
import java.nio.file.WatchEvent

enum class AppPage {
    Home,
    Task
}

class MainActivity : ComponentActivity() {
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
                            TaskScreen(navController = navController)
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
                text = "testですよ",
                modifier = Modifier
            )
        }

        NavigationContent(navController = navController)
    }
}

@Composable
fun TaskScreen (navController: NavHostController,modifier: Modifier = Modifier) {
    Box {
        Card {

        }

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
        Button(onClick = {}) {
            Text("記録")
        }
        Button(onClick = {}) {
            Text("マイページ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pictus_appTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}