package ir.postex.pos.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lir/postex/pos/utils/PriceFormatter;", "", "()V", "formatter", "Ljava/text/DecimalFormat;", "format", "", "amount", "", "", "formatWithCustomSeparator", "separator", "formatWithRials", "formatWithTomans", "app_release"})
public final class PriceFormatter {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.DecimalFormat formatter = null;
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.utils.PriceFormatter INSTANCE = null;
    
    private PriceFormatter() {
        super();
    }
    
    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String format(int amount) {
        return null;
    }
    
    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت Long
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String format(long amount) {
        return null;
    }
    
    /**
     * فرمت کردن مبلغ با جدا کردن سه رقم سه رقم
     * @param amount مبلغ به صورت String
     * @return مبلغ فرمت شده مانند 1,250,000
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String format(@org.jetbrains.annotations.NotNull()
    java.lang.String amount) {
        return null;
    }
    
    /**
     * فرمت کردن مبلغ با واحد تومان
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده با تومان مانند 1,250,000 تومان
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatWithTomans(int amount) {
        return null;
    }
    
    /**
     * فرمت کردن مبلغ با واحد ریال
     * @param amount مبلغ به صورت Int
     * @return مبلغ فرمت شده با ریال مانند 1,250,000 ریال
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatWithRials(int amount) {
        return null;
    }
    
    /**
     * فرمت کردن مبلغ با جداکننده دلخواه
     * @param amount مبلغ به صورت Int
     * @param separator جداکننده مانند . یا /
     * @return مبلغ فرمت شده مانند 1.250.000
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatWithCustomSeparator(int amount, @org.jetbrains.annotations.NotNull()
    java.lang.String separator) {
        return null;
    }
}