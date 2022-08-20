package com.snapy.app.features.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.snapy.app.features.auth.AuthScreen

@Composable
fun NavigationControl() {
    val controller = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        Navigation(controller)
    }
}

@Composable
fun Navigation(controller: NavHostController) {
    NavHost(
        navController = controller,
        startDestination = Routes.WELCOME_ROUTE
    )
    {
        composable(Routes.WELCOME_ROUTE) { AuthScreen() }
    }
}