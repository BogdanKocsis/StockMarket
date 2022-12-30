package com.pdmpa.stockmarketapp.navigation

interface Destinations {
    val route: String
}

object Splash : Destinations {
    override val route = "splash_screen"
}

object Login : Destinations {
    override val route = "login_screen"
}

object SignUp : Destinations {
    override val route = "signup_screen"
}

object Home : Destinations {
    override val route = "home_screen"
}

object CompanyInfo : Destinations {
    override val route = "info_screen"
}

object Profile : Destinations {
    override val route = "profile_screen"
}