package com.persianswitch.smartpos.webservice;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0001\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u009a\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\b\u0003\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00c6\u0001\u00a2\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0003H\u00d6\u0001J\t\u00104\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0007\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001b\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00065"}, d2 = {"Lcom/persianswitch/smartpos/webservice/LoginResponse;", "", "defaultAddressId", "", "email", "", "firstName", "isShahkarValidate", "", "lastName", "mobileNo", "refreshToken", "roles", "", "token", "username", "valueAddedRequirements", "Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;)V", "getDefaultAddressId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmail", "()Ljava/lang/String;", "getFirstName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastName", "getMobileNo", "getRefreshToken", "getRoles", "()Ljava/util/List;", "getToken", "getUsername", "getValueAddedRequirements", "()Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/persianswitch/smartpos/webservice/ValueAddedRequirements;)Lcom/persianswitch/smartpos/webservice/LoginResponse;", "equals", "other", "hashCode", "toString", "app_release"})
public final class LoginResponse {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer defaultAddressId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String firstName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isShahkarValidate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lastName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mobileNo = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String refreshToken = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> roles = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String token = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String username = null;
    @org.jetbrains.annotations.Nullable()
    private final com.persianswitch.smartpos.webservice.ValueAddedRequirements valueAddedRequirements = null;
    
    public LoginResponse(@com.squareup.moshi.Json(name = "default_address_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultAddressId, @com.squareup.moshi.Json(name = "email")
    @org.jetbrains.annotations.Nullable()
    java.lang.String email, @com.squareup.moshi.Json(name = "first_name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String firstName, @com.squareup.moshi.Json(name = "is_shahkar_validate")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isShahkarValidate, @com.squareup.moshi.Json(name = "last_name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String lastName, @com.squareup.moshi.Json(name = "mobile_no")
    @org.jetbrains.annotations.Nullable()
    java.lang.String mobileNo, @com.squareup.moshi.Json(name = "refresh_token")
    @org.jetbrains.annotations.Nullable()
    java.lang.String refreshToken, @com.squareup.moshi.Json(name = "roles")
    @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> roles, @com.squareup.moshi.Json(name = "token")
    @org.jetbrains.annotations.Nullable()
    java.lang.String token, @com.squareup.moshi.Json(name = "username")
    @org.jetbrains.annotations.Nullable()
    java.lang.String username, @com.squareup.moshi.Json(name = "value_added_requirements")
    @org.jetbrains.annotations.Nullable()
    com.persianswitch.smartpos.webservice.ValueAddedRequirements valueAddedRequirements) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDefaultAddressId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isShahkarValidate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMobileNo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRefreshToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getRoles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.persianswitch.smartpos.webservice.ValueAddedRequirements getValueAddedRequirements() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.persianswitch.smartpos.webservice.ValueAddedRequirements component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.persianswitch.smartpos.webservice.LoginResponse copy(@com.squareup.moshi.Json(name = "default_address_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer defaultAddressId, @com.squareup.moshi.Json(name = "email")
    @org.jetbrains.annotations.Nullable()
    java.lang.String email, @com.squareup.moshi.Json(name = "first_name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String firstName, @com.squareup.moshi.Json(name = "is_shahkar_validate")
    @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isShahkarValidate, @com.squareup.moshi.Json(name = "last_name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String lastName, @com.squareup.moshi.Json(name = "mobile_no")
    @org.jetbrains.annotations.Nullable()
    java.lang.String mobileNo, @com.squareup.moshi.Json(name = "refresh_token")
    @org.jetbrains.annotations.Nullable()
    java.lang.String refreshToken, @com.squareup.moshi.Json(name = "roles")
    @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> roles, @com.squareup.moshi.Json(name = "token")
    @org.jetbrains.annotations.Nullable()
    java.lang.String token, @com.squareup.moshi.Json(name = "username")
    @org.jetbrains.annotations.Nullable()
    java.lang.String username, @com.squareup.moshi.Json(name = "value_added_requirements")
    @org.jetbrains.annotations.Nullable()
    com.persianswitch.smartpos.webservice.ValueAddedRequirements valueAddedRequirements) {
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