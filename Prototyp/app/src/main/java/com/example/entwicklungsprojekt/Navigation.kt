package com.example.entwicklungsprojekt

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "startScreen") {
        composable(NavScreen.Start.route) { Start(navController = navController) }
        composable(NavScreen.UserPref.route) { UserPref(navController = navController) }
        composable(NavScreen.NewMeeting.route) { NewMeeting(navController = navController) }
        composable(NavScreen.AllMeeting.route) { AllMeeting(navController = navController) }
        composable(NavScreen.SingleMeeting.route + "/{index}", listOf(navArgument("index") { type = NavType.StringType })
        ) { entry ->
            entry.arguments?.getString("index")
                ?.let { SingleMeeting(navController = navController,meetingIndex = it) }
        }
        composable(NavScreen.JoinedMeeting.route) { JoinedMeeting(navController = navController) }
        composable(NavScreen.RecommendedMeeting.route) { RecommendedMeeting(navController = navController) }
        composable(NavScreen.PrototypeMeeting.route) { PrototypeMeeting(navController = navController) }
    }
}

sealed class NavScreen(val route:String){

    object Start:NavScreen("startScreen")
    object AllMeeting:NavScreen("alleTreffen")
    object NewMeeting:NavScreen("newMeeting")
    object UserPref:NavScreen("pref")
    object SingleMeeting:NavScreen("singleMeeting")
    object JoinedMeeting:NavScreen("joinedMeeting")
    object RecommendedMeeting:NavScreen("recommendedMeeting")
    object PrototypeMeeting:NavScreen("prototypeMeeting")

    fun withArg(vararg arg:String):String{
        return buildString {
            append(route)
            arg.forEach { arg -> append("/$arg") }
        }
    }
}