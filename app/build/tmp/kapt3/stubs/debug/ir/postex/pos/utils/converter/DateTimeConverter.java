package ir.postex.pos.utils.converter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lir/postex/pos/utils/converter/DateTimeConverter;", "", "()V", "LOCAL_DATE_TIME_PATTERN", "", "LOCAL_DATE_TIME_PATTERN_EXP", "SERVER_EXPIRE_DATE_TIME_PATTERN", "SERVER_ORDER_DATE_TIME_PATTERN", "SERVER_TIME_ZONE", "localTimeZone", "kotlin.jvm.PlatformType", "convertServerExpireTimeToLocalTime", "expireTimestamp", "convertServerOrderTimeToLocalTime", "orderTimestamp", "app_debug"})
public final class DateTimeConverter {
    private static final java.lang.String localTimeZone = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SERVER_TIME_ZONE = "UTC";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SERVER_ORDER_DATE_TIME_PATTERN = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS\'Z\'";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SERVER_EXPIRE_DATE_TIME_PATTERN = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOCAL_DATE_TIME_PATTERN_EXP = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.utils.converter.DateTimeConverter INSTANCE = null;
    
    private DateTimeConverter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertServerOrderTimeToLocalTime(@org.jetbrains.annotations.NotNull()
    java.lang.String orderTimestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertServerExpireTimeToLocalTime(@org.jetbrains.annotations.NotNull()
    java.lang.String expireTimestamp) {
        return null;
    }
}