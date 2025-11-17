package jp.wings.nikkeibp.pictus_app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.ui.components.NavigationContent

@Composable
fun Home (navController: NavHostController, modifier: Modifier = Modifier) {
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