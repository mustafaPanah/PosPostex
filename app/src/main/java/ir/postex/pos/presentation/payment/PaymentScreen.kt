package ir.postex.pos.presentation.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.orderdetail.OrderDetailsScreen
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary

@Composable
fun PaymentScreen(
    navController: NavHostController?,
    // onBackClick: () -> Unit = {},
    // onConfirmClick: (String) -> Unit = {}
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        var orderId by remember { mutableStateOf(TextFieldValue("")) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            // 🔙 آیکون بازگشت
            IconButton(
                onClick = { navController?.popBackStack()  },
                modifier = Modifier.align(Alignment.End) // آیکون سمت راست
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, // 👈 آیکون فلش به سمت چپ
                    contentDescription = "بازگشت",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 🧾 عنوان
            Text(
                text = "پرداخت",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            // 📝 توضیح زیر عنوان
            Text(
                text = "شناسه سفارش را وارد نمایید",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 24.dp)
            )

            // 🧩 فیلد ورود شناسه
            OutlinedTextField(
                value = orderId,
                onValueChange = { newValue ->
                    orderId = newValue  },
                singleLine = true,
                label = { Text("شناسه پرداخت") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MainPrimary,     // رنگ حین فوکوس
                    unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                    disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                    errorBorderColor = Color.Red                // رنگ در حالت خطا
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(Modifier.height(32.dp))
            // 🔘 دکمه تایید
            Button(
                onClick = { navController?.navigate(NavigationRoutes.OrderDetailsScreen) },
                enabled = orderId.text.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (orderId.text.isNotBlank()) MainPrimary else Color(0xFFE0E0E0),
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray
                )
            ) {
                Text(text = "تأیید", fontSize = 16.sp,
                    fontFamily = IranSans)
            }
        }
    }
}
