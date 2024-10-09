package com.example.amit_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.amit_project.ui.screens.detailsscreen.DetailsScreen
import com.example.amit_project.ui.screens.mainscreen.MainScreen
import com.example.amit_project.ui.theme.Amit_ProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Amit_ProjectTheme {
               Scaffold(
                   content = { paddingValues ->
                   MealsAppCompose(modifier = Modifier.padding(paddingValues))
                    }
               )
            }
        }
    }
}

@Composable
fun MealsAppCompose(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable(Screen.MainScreen.route) { MainScreen(modifier,navController) }
        composable(
            "${Screen.MealDetailsScreen.route}/{Category}",
            arguments = listOf(navArgument("Category") { type = NavType.StringType; nullable = true })
        ) { _ ->
            DetailsScreen(modifier = modifier)
        }
    }
}
