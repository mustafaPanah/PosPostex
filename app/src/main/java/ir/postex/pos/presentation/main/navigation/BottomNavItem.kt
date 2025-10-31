package ir.postex.pos.presentation.main.navigation

import androidx.annotation.DrawableRes
import ir.postex.pos.R
import ir.postex.pos.utils.presentation.UiText

sealed class BottomNavItem(
    var id: Int,
    var title: UiText,
    @DrawableRes var icon: Int,
    var route: NavigationRoutes,
) {
    data object HomeScreen :
        BottomNavItem(
            id = 1,
            title = UiText.StringResource(R.string.start),
            icon = R.drawable.home,
            route = NavigationRoutes.HomeScreen,
        )


//    data object Orders :
//        BottomNavItem(
//            id = 2,
//            title = UiText.StringResource(R.string.orders),
//            icon = R.drawable.activity,
//            route = NavigationRoutes.OrderScreen,
//        )
//
//    data object Notifications :
//        BottomNavItem(
//            id = 3,
//            title = UiText.StringResource(R.string.notifications),
//            icon = R.drawable.more,
//            route = NavigationRoutes.NotificationsScreen,
//        )

}