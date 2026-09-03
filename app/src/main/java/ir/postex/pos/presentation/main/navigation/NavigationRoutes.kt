package ir.postex.pos.presentation.main.navigation

import android.net.Uri
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
    data class OrderDetailsScreen(val parcelNo:String,val inquiryData: String) : NavigationRoutes

    @Serializable
    data object VerifyScreen : NavigationRoutes

    @Serializable
    data class PaymentResultScreen(val isSuccess: Boolean,
                                    val amount: String,
                                    val trackingNumber: String,
                                    val dateTime: String) : NavigationRoutes
    @Serializable
    data object IncreaseBalanceScreen : NavigationRoutes
    @Serializable
    data object ReportScreen : NavigationRoutes


    @Serializable
    data object ConfigScreen : NavigationRoutes

//    data object OrderDetailsScreen : NavigationRoutes {
//        fun passData(inquiryData: InquiryResponse): String {
//            return "order_details?inquiryData=${Uri.encode(Json.encodeToString(inquiryData))}"
//        }
//    }
}