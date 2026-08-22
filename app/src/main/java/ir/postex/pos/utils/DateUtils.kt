package ir.postex.pos.utils

import kotlin.math.floor
import java.time.DayOfWeek
import java.time.LocalDate

object DateUtils {

    /**
     * تبدیل تاریخ میلادی به شمسی
     * خروجی: Triple<سال شمسی, ماه شمسی, روز شمسی>
     */
    fun gregorianToJalali(gy: Int, gm: Int, gd: Int): Triple<Int, Int, Int> {
        val g_d_m = intArrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
        var gy2 = gy - 1600
        var gm2 = gm - 1
        var gd2 = gd - 1

        var g_day_no = 365 * gy2 + floor((gy2 + 3) / 4.0) - floor((gy2 + 99) / 100.0) + floor((gy2 + 399) / 400.0)
        g_day_no += g_d_m[gm2] + gd2
        if (gm2 > 1 && ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0))) g_day_no += 1

        var j_day_no = g_day_no - 79
        val j_np = floor(j_day_no / 12053.0)
        j_day_no %= 12053
        var jy = (979 + 33 * j_np + 4 * floor(j_day_no / 1461.0)).toInt()
        j_day_no %= 1461
        if (j_day_no >= 366) {
            jy += floor((j_day_no - 1) / 365.0).toInt()
            j_day_no = (j_day_no - 1) % 365
        }

        val jMonthDays = intArrayOf(31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29)
        var jm = 0
        var jd = 0
        for (i in 0..11) {
            if (j_day_no < jMonthDays[i]) {
                jm = i + 1
                jd = (j_day_no + 1).toInt()
                break
            }
            j_day_no -= jMonthDays[i]
        }
     //   return Triple(jy, jm, jd)
        return Triple(jd, jm, jy)
    }

    /**
     * برگرداندن نام فارسی روز هفته
     */
    fun getPersianWeekDayName(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            6 -> "شنبه"      // Saturday
            7 -> "یکشنبه"    // Sunday
            1 -> "دوشنبه"    // Monday
            2 -> "سه‌شنبه"   // Tuesday
            3 -> "چهارشنبه"  // Wednesday
            4 -> "پنج‌شنبه"  // Thursday
            5 -> "جمعه"      // Friday
            else -> ""
        }
    }

    /**
     * دریافت روز هفته فارسی از LocalDate
     */
    fun getPersianWeekDayName(date: LocalDate): String {
        return getPersianWeekDayName(date.dayOfWeek.value)
    }

    /**
     * گرفتن تاریخ شمسی امروز
     */
    fun getTodayJalaliDate(): Triple<Int, Int, Int> {
        val today = LocalDate.now()
        return gregorianToJalali(today.year, today.monthValue, today.dayOfMonth)
    }

    /**
     * برگرداندن رشته کامل تاریخ شمسی مثل "شنبه - 1404/08/03"
     */
    fun getFullPersianDateString(): String {
        val today = LocalDate.now()
        val (jy, jm, jd) = gregorianToJalali(today.year, today.monthValue, today.dayOfMonth)
        val weekday = getPersianWeekDayName(today)
        return "$weekday - $jy/$jm/$jd"
    }
}