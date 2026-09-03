package ir.postex.pos.presentation.main.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0018B)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u0082\u0001\u0001\u0019\u00a8\u0006\u001a"}, d2 = {"Lir/postex/pos/presentation/main/navigation/BottomNavItem;", "", "id", "", "title", "Lir/postex/pos/utils/presentation/UiText;", "icon", "route", "Lir/postex/pos/presentation/main/navigation/NavigationRoutes;", "(ILir/postex/pos/utils/presentation/UiText;ILir/postex/pos/presentation/main/navigation/NavigationRoutes;)V", "getIcon", "()I", "setIcon", "(I)V", "getId", "setId", "getRoute", "()Lir/postex/pos/presentation/main/navigation/NavigationRoutes;", "setRoute", "(Lir/postex/pos/presentation/main/navigation/NavigationRoutes;)V", "getTitle", "()Lir/postex/pos/utils/presentation/UiText;", "setTitle", "(Lir/postex/pos/utils/presentation/UiText;)V", "HomeScreen", "Lir/postex/pos/presentation/main/navigation/BottomNavItem$HomeScreen;", "app_release"})
public abstract class BottomNavItem {
    private int id;
    @org.jetbrains.annotations.NotNull()
    private ir.postex.pos.utils.presentation.UiText title;
    private int icon;
    @org.jetbrains.annotations.NotNull()
    private ir.postex.pos.presentation.main.navigation.NavigationRoutes route;
    
    private BottomNavItem(int id, ir.postex.pos.utils.presentation.UiText title, @androidx.annotation.DrawableRes()
    int icon, ir.postex.pos.presentation.main.navigation.NavigationRoutes route) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.utils.presentation.UiText getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.utils.presentation.UiText p0) {
    }
    
    public final int getIcon() {
        return 0;
    }
    
    public final void setIcon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.presentation.main.navigation.NavigationRoutes getRoute() {
        return null;
    }
    
    public final void setRoute(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.presentation.main.navigation.NavigationRoutes p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lir/postex/pos/presentation/main/navigation/BottomNavItem$HomeScreen;", "Lir/postex/pos/presentation/main/navigation/BottomNavItem;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"})
    public static final class HomeScreen extends ir.postex.pos.presentation.main.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull()
        public static final ir.postex.pos.presentation.main.navigation.BottomNavItem.HomeScreen INSTANCE = null;
        
        private HomeScreen() {
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}