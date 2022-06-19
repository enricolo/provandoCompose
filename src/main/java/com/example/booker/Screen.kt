package com.example.booker

sealed class Screen(val route: String){
    object FirstScreen: Screen(route = "first_screen")
    object LoginScreen: Screen(route = "login_screen")
    object MainScreen: Screen(route = "main_screen")
    object ReservationScreen: Screen(route = "reservation_screen")
    object DaySelectorScreen: Screen(route = "day_selector_screen")
    object TurnSelectorScreen: Screen(route = "turn_selector_screen")
    object ConfirmationScreen: Screen(route = "confirmation_screen")
    object RecapScreen: Screen(route = "recap_screen")


    fun withArgs( vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
