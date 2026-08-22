package ir.postex.pos.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat

class PriceVisualTransformation : VisualTransformation {

    private val formatter = DecimalFormat("#,###")

    override fun filter(text: AnnotatedString): TransformedText {

        val original = text.text

        if (original.isEmpty()) {
            return TransformedText(
                AnnotatedString(""),
                OffsetMapping.Identity
            )
        }

        val digits = original.filter { it.isDigit() }

        val formatted = formatter.format(digits.toLong())

        val offsetMapping = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {

                var transformedOffset = 0
                var originalIndex = 0

                while (transformedOffset < formatted.length && originalIndex < offset) {
                    if (formatted[transformedOffset].isDigit()) {
                        originalIndex++
                    }
                    transformedOffset++
                }

                return transformedOffset
            }

            override fun transformedToOriginal(offset: Int): Int {

                var originalOffset = 0

                for (i in 0 until minOf(offset, formatted.length)) {
                    if (formatted[i].isDigit()) {
                        originalOffset++
                    }
                }

                return originalOffset.coerceAtMost(digits.length)
            }
        }

        return TransformedText(
            AnnotatedString(formatted),
            offsetMapping
        )
    }
}