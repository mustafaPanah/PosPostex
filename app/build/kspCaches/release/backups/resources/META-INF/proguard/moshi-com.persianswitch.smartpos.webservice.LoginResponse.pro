-if class com.persianswitch.smartpos.webservice.LoginResponse
-keepnames class com.persianswitch.smartpos.webservice.LoginResponse
-if class com.persianswitch.smartpos.webservice.LoginResponse
-keep class com.persianswitch.smartpos.webservice.LoginResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
