package ir.postex.pos.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.navigation.toRoute
import dagger.hilt.android.AndroidEntryPoint
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.pos.PosResponse
import ir.postex.pos.domain.model.pos.PosSettingsResponse
import ir.postex.pos.presentation.config.ConfigScreen
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
import ir.postex.pos.security.PrivateKeyStorage
import kotlinx.serialization.json.Json
import timber.log.Timber
import java.security.MessageDigest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var pendingPosCallback: ((PosResponse) -> Unit)? = null
    private var pendingSettingsCallback: ((PosSettingsResponse) -> Unit)? = null
    private lateinit var settingsLauncher: ActivityResultLauncher<Intent>
    // لانچر ActivityResult
    private lateinit var posLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Timber.tag("SHA").e(sha256Hex("hello".toByteArray()))
        Timber.tag("SHA").e(sha256FromBytes("hello".toByteArray()))
        Timber.tag("SHA").e("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824")
        posLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val bundle = result.data?.getBundleExtra("DATA")
                    val resp = PosResponse(
                        status = bundle?.getBoolean("STATUS") ?: false,
                        date = bundle?.getString("DATE"),
                        time = bundle?.getString("TIME"),
                        stan = bundle?.getString("STAN"),
                        rrn = bundle?.getString("RRN"),
                        response = bundle?.getString("RESPONSE"),
                        guid = bundle?.getString("GUID"),
                        amount = bundle?.getString("AMOUNT")
                    )
                    pendingPosCallback?.invoke(resp)
                } else {
                    // در صورت نیاز می‌تونیم یک پاسخ ناموفق ارسال کنیم
                    pendingPosCallback?.invoke(
                        PosResponse(
                            status = false, date = null, time = null,
                            stan = null, rrn = null, response = null, guid = null, amount = null
                        )
                    )
                }
                // یک‌بار مصرف
                pendingPosCallback = null
            }
        settingsLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val bundle = result.data?.getBundleExtra("DATA")
                val response = PosSettingsResponse(
                    version = bundle?.getString("VERSION"),
                    firmware = bundle?.getString("FIRMWARE"),
                    terminal = bundle?.getString("TERMINAL"),
                    merchant = bundle?.getString("MERCHANT"),
                    name = bundle?.getString("NAME")
                )
                pendingSettingsCallback?.invoke(response)
            } else {
                pendingSettingsCallback?.invoke(
                    PosSettingsResponse(null, null, null, null, null)
                )
            }
            pendingSettingsCallback = null // یکبار مصرف


        }
        setContent {

            val storage = PrivateKeyStorage(this@MainActivity)
            val keyPair = storage.loadKeyPair()

            if (keyPair != null) {
                val privateKeyBase64 = Base64.encodeToString(keyPair.private.encoded, Base64.NO_WRAP)
                val publicKeyBase64 = Base64.encodeToString(keyPair.public.encoded, Base64.NO_WRAP)

                Log.e("Keys", "Private Key: $privateKeyBase64")
                Log.e("Keys", "Public Key: $publicKeyBase64")
            } else {
                Log.e("Keys", "No key pair found")
            }
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
                                               NavigationRoutes.LoginScreen
                                             //  NavigationRoutes.PaymentSuccessScreen
                                          //  NavigationRoutes.HomeScreen
                                        )
                                    },
                                    navigateToHome = {
                                        navController.navigateSingleTopTo(
                                            NavigationRoutes.LoginScreen
                                         //   NavigationRoutes.HomeScreen
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
                                PaymentScreen(
                                    navController = navController,
                                    onLaunchPos = { amount, onResult ->
                                        // this@MainActivity اشاره به Activity جاری دارد
                                        this@MainActivity.launchPos(amount) { posResp ->
                                            onResult(posResp)
                                        }
                                    }
                                )
                            }
//                            composable<NavigationRoutes.OrderDetailsScreen> {
//                                OrderDetailsScreen(navController)
//                            }

                            composable<NavigationRoutes.OrderDetailsScreen> { backStackEntry ->
                                val args = backStackEntry.toRoute<NavigationRoutes.OrderDetailsScreen>()
                                val inquiryData = Json.decodeFromString<InquiryResponse>(args.inquiryData)
                                OrderDetailsScreen(navController, args.parcelNo, inquiryData, onLaunchPos = { amount, onResult ->
                                    // this@MainActivity اشاره به Activity جاری دارد
                                    this@MainActivity.launchPos(amount) { posResp ->
                                        onResult(posResp)
                                    }
                                })
                            }


                            composable<NavigationRoutes.IncreaseBalanceScreen> {
                                IncreaseBalanceScreen(navController,
                                    onLaunchPos = { amount, onResult ->
                                        // this@MainActivity اشاره به Activity جاری دارد
                                        this@MainActivity.launchPos(amount) { posResp ->
                                            onResult(posResp)
                                        }
                                    }
                                    )
                            }

                            composable<NavigationRoutes.ReportScreen> {
                                ReportScreen(navController)
                            }
                            composable<NavigationRoutes.ConfigScreen> {
                                ConfigScreen(this@MainActivity ,navController)
                            }

                            composable<NavigationRoutes.PaymentResultScreen> { backStackEntry ->
                                val args = backStackEntry.toRoute<NavigationRoutes.PaymentResultScreen>()
                                PaymentResultScreen(
                                    isSuccess = args.isSuccess,
                                    amount = args.amount,
                                    trackingNumber = args.trackingNumber,
                                    dateTime = args.dateTime,
                                    navController = navController
                                )
                            }
//                            composable<NavigationRoutes.PaymentResultScreen> {
//                                PaymentResultScreen(
//                                    true,
//                                    "1000",
//                                    "123455",
//                                    "34254545",
//                                    navController
//                                )
//                            }
                            composable<NavigationRoutes.FilterScreen> {
                                FilterScreen(navController)
                            }
                        }

                    }
                }

            }
        }
    }

    fun launchPos(amount: String, callback: (PosResponse) -> Unit) {
        val intent = Intent().apply {
            action = "com.fanap.androidpos.TpActivity"
            type = "text/plain"
            putExtra("DATA", Bundle().apply {
                putString("AMOUNT", amount)
                putString("GUID", random10DigitString())
            })
        }

        if (intent.resolveActivity(packageManager) != null) {
            pendingPosCallback = callback
            posLauncher.launch(intent)
        } else {
            Toast.makeText(this, "برنامه پوز روی دستگاه نصب نمی باشد!", Toast.LENGTH_SHORT).show()
            // بازگشت پاسخ ناموفق بلافاصله
            callback(PosResponse(false, null, null, null, null, "POS not installed", null, amount))
        }
    }
    fun launchSettings(callback: (PosSettingsResponse) -> Unit) {
        val intent = Intent().apply {
            action = "com.fanap.androidpos.TpSettingsActivity"
        }

        if (intent.resolveActivity(packageManager) != null) {
            pendingSettingsCallback = callback
            settingsLauncher.launch(intent)
        } else {
            Toast.makeText(this, "برنامه پوز روی دستگاه نصب نمی باشد!", Toast.LENGTH_SHORT).show()
            callback(PosSettingsResponse(null, null, null, null, null))
        }
    }
}
fun sha256FromBytes(bytes: ByteArray?): String {
    try {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(bytes)
        val hex = java.lang.StringBuilder()
        for (b in hash) {
            hex.append(String.format("%02x", b))
        }
        return hex.toString()
    } catch (e: java.lang.Exception) {
        throw java.lang.RuntimeException("SHA-256 failed", e)
    }
}

fun sha256Hex(bytes: ByteArray): String {
    return try {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(bytes)
        val hex = StringBuilder()
        for (b in hash) {
            hex.append(String.format("%02x", b))
        }
        hex.toString()
    } catch (e: Exception) {
        throw RuntimeException("SHA-256 failed", e)
    }
}
private fun random10DigitString(): String {
    val rnd = java.security.SecureRandom()
    val sb = StringBuilder(10)
    sb.append(rnd.nextInt(9) + 1)
    repeat(9) { sb.append(rnd.nextInt(10)) }
    return sb.toString()
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


