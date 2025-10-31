package ir.postex.pos.presentation.main.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoutes {
    @Serializable
    data object SplashScreen : NavigationRoutes

    @Serializable
    data object LoginScreen : NavigationRoutes

    @Serializable
    data object  HomeScreen : NavigationRoutes

    @Serializable
    data object  PaymentScreen : NavigationRoutes

    @Serializable
    data object  OrderDetailsScreen : NavigationRoutes

    @Serializable
    data object VerifyScreen : NavigationRoutes

    @Serializable
    data object PaymentResultScreen : NavigationRoutes
    @Serializable
    data object IncreaseBalanceScreen : NavigationRoutes
    @Serializable
    data object ReportScreen : NavigationRoutes
    @Serializable
    data object FilterScreen : NavigationRoutes
}