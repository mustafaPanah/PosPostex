package ir.postex.pos.presentation.main;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u001a\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lir/postex/pos/presentation/main/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "pendingPosCallback", "Lkotlin/Function1;", "Lir/postex/pos/domain/model/pos/PosResponse;", "", "pendingSettingsCallback", "Lir/postex/pos/domain/model/pos/PosSettingsResponse;", "posLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "settingsLauncher", "launchPos", "amount", "", "callback", "launchSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super ir.postex.pos.domain.model.pos.PosResponse, kotlin.Unit> pendingPosCallback;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super ir.postex.pos.domain.model.pos.PosSettingsResponse, kotlin.Unit> pendingSettingsCallback;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> settingsLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> posLauncher;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void launchPos(@org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ir.postex.pos.domain.model.pos.PosResponse, kotlin.Unit> callback) {
    }
    
    public final void launchSettings(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ir.postex.pos.domain.model.pos.PosSettingsResponse, kotlin.Unit> callback) {
    }
}