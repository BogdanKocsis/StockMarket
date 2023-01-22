package com.pdmpa.stockmarketapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pdmpa.stockmarketapp.presentation.infocompany.CompanyInfoScreen
import com.pdmpa.stockmarketapp.presentation.listingscompany.CompanyListingsScreen
import com.pdmpa.stockmarketapp.presentation.login.LoginScreen
import com.pdmpa.stockmarketapp.presentation.onBoarding.OnBoardingScreen
import com.pdmpa.stockmarketapp.presentation.profile.ProfileScreen
import com.pdmpa.stockmarketapp.presentation.resetPassword.ResetPasswordScreen
import com.pdmpa.stockmarketapp.presentation.signup.SignUpScreen
import com.pdmpa.stockmarketapp.presentation.splash_screen.SplashScreen

@Composable
fun StockMarketNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = ResetPassword.route) {
            ResetPasswordScreen(navController = navController)
        }
        composable(route = Home.route) {
            CompanyListingsScreen(navController = navController)
        }
        composable(
            route = CompanyInfo.route + "/{symbol}",
            arguments = listOf(navArgument("symbol") { type = NavType.StringType })
        ) {
            CompanyInfoScreen()
        }
        composable(route = Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}