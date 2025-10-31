package ir.postex.pos.presentation.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.postex.pos.R

@Composable
fun CircularIcon90(
    @DrawableRes iconRes: Int,
    contentDescription: String? = null,
    bgColor: Color = Color(0xFFE0E0E0),      // خاکستری ملایم
    iconFraction: Float = 0.6f,              // اندازه‌ی آیکون نسبت به قطر دایره
    tint: Color? = null                      // اگر بخوای رنگ آیکون تک‌رنگ رو عوض کنی
) {
    Box(
        modifier = Modifier
            .size(90.dp)                     // ۹۰ در ۹۰ dp
            .clip(CircleShape)               // دایره‌ای
            .background(bgColor),            // بک‌گراند خاکستری
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(90.dp * iconFraction),
            contentScale = ContentScale.Fit,
            colorFilter = tint?.let { ColorFilter.tint(it) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CircularIcon90Preview() {
    CircularIcon90(iconRes = R.drawable.ic_leaf, contentDescription = "Leaf")
}