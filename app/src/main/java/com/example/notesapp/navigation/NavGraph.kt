package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.viewmodel.NotesViewModel
import com.example.notesapp.ui.theme.screens.HomeScreen
import com.example.notesapp.ui.theme.screens.DetailScreen
import com.example.notesapp.ui.theme.screens.AddEditScreen


import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notesapp.ui.theme.screens.LoginScreen
import com.example.notesapp.ui.theme.screens.SignupScreen
import com.example.notesapp.viewmodel.AuthViewModel


@Composable
fun AppNavigation(viewModel: NotesViewModel, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable(route = "login") {
            LoginScreen(navController = navController, viewModel = authViewModel)
        }

        composable(route = "signup") {
            SignupScreen(navController = navController, viewModel = authViewModel)
        }

        composable(route = "home") {
            HomeScreen(navController = navController, viewModel = viewModel, authViewModel = authViewModel)
        }

        composable(
            "detail/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            DetailScreen(itemId = itemId, viewModel = viewModel, navController = navController)
        }

        composable("add") {
            AddEditScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            "edit/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            AddEditScreen(itemId = itemId, viewModel = viewModel, navController = navController)
        }
    }
}