package ir.postex.pos.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bJ0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lir/postex/pos/utils/DateUtils;", "", "()V", "getFullPersianDateString", "", "getPersianWeekDayName", "date", "Ljava/time/LocalDate;", "dayOfWeek", "", "getTodayJalaliDate", "Lkotlin/Triple;", "gregorianToJalali", "gy", "gm", "gd", "app_release"})
public final class DateUtils {
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.utils.DateUtils INSTANCE = null;
    
    private DateUtils() {
        super();
    }
    
    /**
     * تبدیل تاریخ میلادی به شمسی
     * خروجی: Triple<سال شمسی, ماه شمسی, روز شمسی>
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Integer> gregorianToJalali(int gy, int gm, int gd) {
        return null;
    }
    
    /**
     * برگرداندن نام فارسی روز هفته
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersianWeekDayName(int dayOfWeek) {
        return null;
    }
    
    /**
     * دریافت روز هفته فارسی از LocalDate
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersianWeekDayName(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date) {
        return null;
    }
    
    /**
     * گرفتن تاریخ شمسی امروز
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Integer> getTodayJalaliDate() {
        return null;
    }
    
    /**
     * برگرداندن رشته کامل تاریخ شمسی مثل "شنبه - 1404/08/03"
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFullPersianDateString() {
        return null;
    }
}