package com.persianswitch.smartpos.webservice;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJn\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;", "", "dropOff", "", "engineeringFee", "insurance", "logo", "packaging", "print", "register", "sms", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDropOff", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEngineeringFee", "getInsurance", "getLogo", "getPackaging", "getPrint", "getRegister", "getSms", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class ValueAddedRequirements {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean dropOff = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean engineeringFee = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean insurance = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean logo = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean packaging = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean print = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean register = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean sms = null;
    
    public ValueAddedRequirements(@com.squareup.moshi.Json(name = "drop_off")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean dropOff, @com.squareup.moshi.Json(name = "engineering_fee")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean engineeringFee, @com.squareup.moshi.Json(name = "insurance")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean insurance, @com.squareup.moshi.Json(name = "logo")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean logo, @com.squareup.moshi.Json(name = "packaging")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean packaging, @com.squareup.moshi.Json(name = "print")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean print, @com.squareup.moshi.Json(name = "register")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean register, @com.squareup.moshi.Json(name = "sms")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean sms) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getDropOff() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getEngineeringFee() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getInsurance() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLogo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getPackaging() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getPrint() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getRegister() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getSms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.persianswitch.smartpos.webservice.ValueAddedRequirements copy(@com.squareup.moshi.Json(name = "drop_off")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean dropOff, @com.squareup.moshi.Json(name = "engineering_fee")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean engineeringFee, @com.squareup.moshi.Json(name = "insurance")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean insurance, @com.squareup.moshi.Json(name = "logo")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean logo, @com.squareup.moshi.Json(name = "packaging")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean packaging, @com.squareup.moshi.Json(name = "print")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean print, @com.squareup.moshi.Json(name = "register")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean register, @com.squareup.moshi.Json(name = "sms")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean sms) {
        return null;
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