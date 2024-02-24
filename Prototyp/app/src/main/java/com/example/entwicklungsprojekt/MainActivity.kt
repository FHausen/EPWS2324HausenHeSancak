package com.example.entwicklungsprojekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.entwicklungsprojekt.ui.theme.EntwicklungsprojektTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntwicklungsprojektTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startScreen") {
        composable("startScreen") {
            Start(
                navController = navController,
                navigateToFindeTreffen = { navController.navigate("findeeinTreffen") }
            ) { navController.navigate("erstelleeinTreffen") }
        }
        composable("findeeinTreffen") {
            FindeTreffen(
                navController = navController
            ) { navController.navigate("spieleTreffen") }
        }
        composable("erstelleeinTreffen") {
            ErstelleTreffen(
                navController = navController
            ) { navController.navigate("spieleTreffen") }
        }
        composable("spieleTreffen") {
            SpielTreffen()
        }
    }
}