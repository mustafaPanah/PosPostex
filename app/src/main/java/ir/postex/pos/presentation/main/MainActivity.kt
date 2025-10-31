package ir.postex.pos.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.postex.pos.presentation.filter.FilterScreen
import ir.postex.pos.presentation.home.HomeScreen
import ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceScreen
import ir.postex.pos.presentation.login.LoginScreen
import ir.postex.pos.presentation.main.navigation.BottomNavItem
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.main.navigation.navigateSingleTopTo
import ir.postex.pos.presentation.orderdetail.OrderDetailsScreen
import ir.postex.pos.presentation.payment.PaymentScreen
import ir.postex.pos.presentation.paymentResultScreen.PaymentResultScreen
import ir.postex.pos.presentation.reportScreen.ReportScreen
import ir.postex.pos.presentation.splash.SplashScreen
import ir.postex.pos.presentation.theme.PostexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostexTheme {
                var selectedId by rememberSaveable {
                    mutableIntStateOf(BottomNavItem.HomeScreen.id)
                }
                val navController = rememberNavController()
                val mainViewModel = hiltViewModel<MainViewModel>()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    val paddingModifier = Modifier.padding(innerPadding)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding()
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationRoutes.SplashScreen
                        ) {
                            composable<NavigationRoutes.SplashScreen> {
                                SplashScreen(
                                    navigateToLogin = {
                                        navController.navigateSingleTopTo(
                                          //  NavigationRoutes.LoginScreen
                                            NavigationRoutes.HomeScreen
                                        )
                                    },
                                    navigateToHome = {
                                        navController.navigateSingleTopTo(
                                              NavigationRoutes.HomeScreen
                                           // NavigationRoutes.IncreaseBalanceScreen
                                        )
                                    }
                                )
                            }
                            composable<NavigationRoutes.LoginScreen> {
                                LoginScreen(this@MainActivity, navController)
                            }
                            composable<NavigationRoutes.HomeScreen> {
                                HomeScreen(this@MainActivity, navController)
                            }
                            composable<NavigationRoutes.PaymentScreen> {
                                PaymentScreen( navController)
                            }
                            composable<NavigationRoutes.OrderDetailsScreen> {
                                OrderDetailsScreen( navController)
                            }
                            composable<NavigationRoutes.IncreaseBalanceScreen> {
                                IncreaseBalanceScreen(navController)
                            }

                            composable<NavigationRoutes.ReportScreen> {
                                ReportScreen(navController)
                            }

                            composable<NavigationRoutes.PaymentResultScreen> {
                                PaymentResultScreen( true,"1000","123455","34254545",navController)
                            }
                            composable<NavigationRoutes.FilterScreen> {
                                FilterScreen( navController)
                            }
                        }

                        }
                    }

                }
            }
        }
    }

    @Composable
    private fun GeneralScreen(modifier: Modifier = Modifier, text: String) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = text, style = MaterialTheme.typography.displayLarge)
        }
    }


