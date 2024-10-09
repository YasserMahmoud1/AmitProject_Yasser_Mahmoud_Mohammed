package com.example.amit_project

sealed class Screen (val route : String){
    object MainScreen : Screen("mainScreen")
    object MealDetailsScreen : Screen("mealDetailsScreen")
}