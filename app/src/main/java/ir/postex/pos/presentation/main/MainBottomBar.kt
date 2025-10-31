package ir.postex.pos.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.postex.pos.presentation.main.navigation.AddNavigationBarItem.AddItem
import ir.postex.pos.presentation.main.navigation.BottomNavItem
import ir.postex.pos.presentation.main.navigation.navigateSingleTopTo
import ir.postex.pos.presentation.theme.NavBackground

@Composable
fun MainBottomBar(
    navController: NavHostController,
    selectedId: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    barHeight: Dp = 80.dp // 👈 custom height
) {
    val items = listOf(
        BottomNavItem.HomeScreen,
      //  BottomNavItem.Orders,
       // BottomNavItem.Notifications
    )

    Surface(
        color = NavBackground,
        shape = RoundedCornerShape(20.dp),
        tonalElevation = 2.dp,
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(barHeight) // 👈 fully custom height
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                AddItem(
                    screen = screen,
                    selected = screen.id == selectedId,
                    onTabClick = {
                        onItemSelected(it)
                        navController.navigateSingleTopTo(screen.route)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun MainBottomBarPreview(){
    MainBottomBar(rememberNavController(), 1, {}, Modifier)
}
