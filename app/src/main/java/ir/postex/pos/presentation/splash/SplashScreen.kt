package ir.postex.pos.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.postex.pos.R
import ir.postex.pos.presentation.theme.MainPrimary


@Composable
fun SplashScreen(
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    val viewModel: SplashViewModel = hiltViewModel()
    val isLogin by viewModel.isLogin.collectAsState()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LaunchedEffect(isLogin) {
            if (isLogin == null) return@LaunchedEffect  // یعنی هنوز لود نشده
            if (isLogin == true) {
                navigateToHome()
            } else {
                navigateToLogin()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
          //  #01A0E1
                .background(MainPrimary),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // آیکون SVG
                Icon(
                    painter = painterResource(id = R.drawable.postex_white),
                    contentDescription = "PostEx Logo",
                    tint = Color.Unspecified, // رنگ اصلی آیکون حفظ شود
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen({}, {})
}
