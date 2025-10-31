package ir.postex.pos.presentation.main.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

object AddNavigationBarItem {
    @Composable
    fun RowScope.AddItem(
        screen: BottomNavItem,
        selected: Boolean,
        onTabClick: (Int) -> Unit
    ) {
        NavigationBarItem(
            // Text that shows bellow the icon
            label = {
                Text(text = screen.title.asString())
            },

            // The icon resource
            icon = {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = screen.title.asString()
                )
            },

            // Display if the icon it is select or not
            selected = selected,

            // Always show the label bellow the icon or not
            alwaysShowLabel = true,

            // Click listener for the icon
            onClick = { onTabClick(screen.id) },

            // Control all the colors of the icon
            colors = NavigationBarItemDefaults.colors()
        )
    }
}