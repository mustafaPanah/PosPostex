package ir.postex.pos.presentation.filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.postex.pos.presentation.theme.MainPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    var showSheet by remember { mutableStateOf(false) }
    var isSelectingStartDate by remember { mutableStateOf(true) }

    var fromDate by remember { mutableStateOf("از تاریخ") }
    var toDate by remember { mutableStateOf("تا تاریخ") }

    var selectedTransactionType by remember { mutableStateOf("") }
    val transactionTypes = listOf("خرید", "شارژ", "قبض")

    var trackingNumber by remember { mutableStateOf("") }
    var orderId by remember { mutableStateOf("") }

    // ✅ BottomSheet محتوا
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            DatePickerBottomSheet(
                onConfirm = { day, month, year ->
                    val result = "$year/$month/$day"
                    if (isSelectingStartDate) fromDate = result else toDate = result
                    showSheet = false
                }
            )
        }
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .imePadding() // ✅ برای باز شدن درست کیبورد
                .verticalScroll(rememberScrollState())
        ) {

            // 🔙 نوار بالایی
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "بازگشت")
                }
                Text(
                    text = "فیلتر",
                    modifier = Modifier.weight(1f),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(48.dp)) // فضا برای تراز وسطی عنوان
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 📅 از تاریخ
            FilterField(
                icon = Icons.Default.DateRange,
                        text = fromDate
            ) {
                isSelectingStartDate = true
                showSheet = true
            }
            Spacer(modifier = Modifier.height(16.dp))
            // 📅 تا تاریخ
            FilterField(
                icon = Icons.Default.DateRange,
                text = toDate

            ) {
                isSelectingStartDate = false
                showSheet = true
            }
            Spacer(modifier = Modifier.height(16.dp))
            // 🔽 نوع تراکنش
            TransactionTypeDropdown(
                selectedType = selectedTransactionType,
                items = transactionTypes,
                onSelect = { selectedTransactionType = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // 🔢 شماره پیگیری
            OutlinedTextField(
                value = trackingNumber,
                onValueChange = { trackingNumber = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("شماره پیگیری") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // 🔢 شناسه سفارش
            OutlinedTextField(
                value = orderId,
                onValueChange = { orderId = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("شناسه سفارش") },
                singleLine = true
            )


            Spacer(modifier = Modifier.height(24.dp))

            // دکمه‌ها
            Button(
                onClick = { /* اعمال فیلتر */ },
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(8.dp)
            ) {
                Text("اعمال", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = {
                    fromDate = "از تاریخ"
                    toDate = "تا تاریخ"
                    trackingNumber = ""
                    orderId = ""
                    selectedTransactionType = ""
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("پاک کردن", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun FilterField(text: String, icon: ImageVector, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text, color = Color.Black)
            Icon(icon, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun TransactionTypeDropdown(
    selectedType: String,
    items: List<String>,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    if (selectedType.isEmpty()) "نوع تراکنش" else selectedType,
                    color = Color.Black
                )
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onSelect(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun DatePickerBottomSheet(onConfirm: (Int, Int, Int) -> Unit) {
    var selectedDay by remember { mutableStateOf(1) }
    var selectedMonth by remember { mutableStateOf(1) }
    var selectedYear by remember { mutableStateOf(1403) }

    val days = (1..31).toList()
    val months = (1..12).toList()
    val years = (1390..1404).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("انتخاب تاریخ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            NumberPicker(
                label = "روز",
                values = days,
                selectedValue = selectedDay,
                onValueChange = { selectedDay = it }
            )
            NumberPicker(
                label = "ماه",
                values = months,
                selectedValue = selectedMonth,
                onValueChange = { selectedMonth = it }
            )
            NumberPicker(
                label = "سال",
                values = years,
                selectedValue = selectedYear,
                onValueChange = { selectedYear = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onConfirm(selectedDay, selectedMonth, selectedYear) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("تایید")
        }
    }
}

@Composable
fun NumberPicker(
    label: String,
    values: List<Int>,
    selectedValue: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    itemHeight: Dp = 36.dp
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(8.dp))

        // state برای لیست و اسکرول به آیتم انتخاب‌شده
        val initialIndex = values.indexOf(selectedValue).coerceAtLeast(0)
        val listState = rememberLazyListState(initialFirstVisibleItemIndex = initialIndex)

        LaunchedEffect(selectedValue) {
            // وقتی selectedValue تغییر کرد، به آیتم مربوطه اسکرول کن
            listState.animateScrollToItem(values.indexOf(selectedValue).coerceAtLeast(0))
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .height(120.dp)
                .width(64.dp), // اندازهٔ پیشنهادی، می‌تونی تغییر بدی
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(values) { item ->
                val isSelected = item == selectedValue
                Text(
                    text = item.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(itemHeight)
                        .clickable { onValueChange(item) }
                        .padding(vertical = 4.dp),
                    textAlign = TextAlign.Center,
                    fontSize = if (isSelected) 18.sp else 14.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) MainPrimary else Color.Black
                )
            }
        }
    }
}
