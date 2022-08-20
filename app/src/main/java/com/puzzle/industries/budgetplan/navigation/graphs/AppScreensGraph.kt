package com.puzzle.industries.budgetplan.navigation.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.puzzle.industries.budgetplan.navigation.constants.MainScreens
import com.puzzle.industries.budgetplan.navigation.constants.Routes
import com.puzzle.industries.budgetplan.screens.MainScreen
import com.puzzle.industries.budgetplan.screens.SplashScreen

@Composable
@ExperimentalMaterial3Api
fun appScreensGraph(navController: NavHostController) : NavGraph {
    return navController.createGraph(startDestination = MainScreens.Splash.name){
        composable(route = Routes.Splash.path){
            SplashScreen{
                navController.navigate(route = Routes.Main.path) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(route = it) {
                            inclusive = true
                        }
                    }
                }
            }
        }

        composable(route = Routes.Main.path){
            MainScreen()
        }
    }
}