package ir.postex.pos.utils

import java.text.DecimalFormat

object PriceFormatter {

    private val formatter = DecimalFormat("#,###")

    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    fun format(amount: Int): String {
        return formatter.format(amount)
    }

    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت Long
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    fun format(amount: Long): String {
        return formatter.format(amount)
    }

    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت String
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    fun format(amount: String): String {
        return try {
            formatter.format(amount.toLong())
        } catch (e: NumberFormatException) {
            amount
        }
    }

    /**
     * فرمت کردن مبلغ با واحد تومان
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده با تومان مانند 1,250,000 تومان
     */
    fun formatWithTomans(amount: Int): String {
        return "${format(amount)} تومان"
    }

    /**
     * فرمت کردن مبلغ با واحد ریال
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده با ریال مانند 1,250,000 ریال
     */
    fun formatWithRials(amount: Int): String {
        return "${format(amount)} ریال"
    }

    /**
     * فرمت کردن مبلغ با جداکننده دلخواه
     * @param amount مبلغ به صورت Int
     * @param separator جداکننده مانند . یا /
     * @return مبلغ فرمت شده مانند 1.250.000
     */
    fun formatWithCustomSeparator(amount: Int, separator: String = ","): String {
        return amount.toString()
            .reversed()
            .chunked(3)
            .joinToString(separator)
            .reversed()
    }
}