package jp.wings.nikkeibp.pictus_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.AppPage

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