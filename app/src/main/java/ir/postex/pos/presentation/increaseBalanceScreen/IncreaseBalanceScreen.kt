package ir.postex.pos.presentation.increaseBalanceScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary

@Composable
fun IncreaseBalanceScreen(
navController: NavController
) {
     var customAmount by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {

            // 🔙 دکمه بازگشت
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.End) // آیکون سمت راست
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, // 👈 آیکون فلش به سمت چپ
                    contentDescription = "بازگشت",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 🧾 عنوان و توضیح
            Text(
                text = "افزایش موجودی",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "مبلغ مورد نظر جهت افزایش موجودی را وارد نمایید",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔢 TextField برای مبلغ
            OutlinedTextField(
                value = customAmount,
                onValueChange = { customAmount = it },
                placeholder = { Text("مبلغ مورد نظر") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MainPrimary,
                    unfocusedBorderColor = Color(0xFFB3E5FC),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = MainPrimary
                ),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 💰 گزینه‌های پیش‌فرض مبالغ
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("200,000", "400,000", "800,000").forEach { amount ->
                    OutlinedButton(
                        onClick = { customAmount=amount.replace(",","") },
                        border = BorderStroke(1.dp, MainPrimary),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MainPrimary
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp)
                    ) {
                        Text(
                            text = amount,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.navigate(NavigationRoutes.PaymentResultScreen)},
                enabled = customAmount.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (customAmount.isNotBlank()) MainPrimary else Color(
                        0xFFE0E0E0
                    ),
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray
                )
            ) {
                Text(
                    text = "تأیید", fontSize = 16.sp,
                    fontFamily = IranSans
                )
            }

        }
    }
}
