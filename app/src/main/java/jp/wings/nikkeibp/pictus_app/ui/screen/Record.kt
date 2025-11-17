package jp.wings.nikkeibp.pictus_app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.ui.components.NavigationContent

@Composable
fun Record (navController: NavHostController,modifier: Modifier = Modifier) {
    Box {
        NavigationContent(navController = navController)
    }
}