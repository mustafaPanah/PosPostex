package ir.postex.pos.presentation.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u001c\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0014"}, d2 = {"HomeCardItem", "", "title", "", "subtitle", "imageRes", "", "onClick", "Lkotlin/Function0;", "HomeScreen", "activity", "Lir/postex/pos/presentation/main/MainActivity;", "navController", "Landroidx/navigation/NavHostController;", "HomeScreenPreview", "getPersianWeekDayName", "calendar", "Ljava/util/Calendar;", "getTodayJalaliDate", "Lkotlin/Triple;", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.Nullable()
    ir.postex.pos.presentation.main.MainActivity activity, @org.jetbrains.annotations.Nullable()
    androidx.navigation.NavHostController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HomeCardItem(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle, @androidx.annotation.DrawableRes()
    int imageRes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Integer> getTodayJalaliDate(@org.jetbrains.annotations.NotNull()
    java.util.Calendar calendar) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPersianWeekDayName(@org.jetbrains.annotations.NotNull()
    java.util.Calendar calendar) {
        return null;
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, backgroundColor = 4294308095L)
    @androidx.compose.runtime.Composable()
    public static final void HomeScreenPreview() {
    }
}