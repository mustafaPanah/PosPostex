
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlinSerialization)
    kotlin("kapt")
    alias(libs.plugins.ksp.devtool)

}

val major = 1
val minor = 0
val patch = 0

val suffix = "release"

val appVersionCode = (major * 1000000) + (minor * 10000) + (patch * 100)
var appVersionName = "$major.$minor.$patch"
if (suffix.isNotEmpty()) appVersionName += "-$suffix"

android {
    namespace = "ir.postex.pos"
    compileSdk = 35

    defaultConfig {
        applicationId = "ir.postex.pos"
        minSdk = 24
        targetSdk = 35
        versionCode = appVersionCode
        versionName = appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            buildConfigField("boolean", "IS_DEBUG", "false")
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = true
            buildConfigField("boolean", "IS_DEBUG", "true")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    applicationVariants.all {
        val variant = this
        outputs.all {
            val output = this as com.android.build.gradle.internal.api.ApkVariantOutputImpl

            val baseName = when (variant.buildType.name) {
                "debug" -> "Postex-debug"
                "release" -> "Postex-release"
                else -> "ir.postex.pos-${variant.buildType.name}"
            }

            output.outputFileName = "$baseName-${variant.versionName}-($appVersionCode).apk"
        }
    }

    tasks.withType<JavaCompile> {
        options.isIncremental = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material2)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.androidx.compose.ui.ui.tooling.preview)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Splash
    implementation(libs.androidx.core.splashscreen)

    // DataStore
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.preferences.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // Moshi
    implementation(libs.moshi)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    ksp(libs.moshi.codegen)

    // chucker
    debugImplementation(libs.chuckerDebug)
    releaseImplementation(libs.chuckerRelease)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)

    // Google font
    implementation(libs.androidx.ui.text.google.fonts)

    // Glide
    implementation(libs.compose.glide)

    // Credentials
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)

    // Browser
    implementation(libs.androidx.browser)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.compose.material:material-icons-extended")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.android.gms:play-services-base:18.5.0") {
        exclude(group = "com.android.support")
    }
    implementation("com.google.android.gms:play-services-ads-identifier:18.1.0") {
        exclude(group = "com.android.support")
    }

    // Swap Refresh
    implementation(libs.accompanist.swiperefresh)

    // Timber
    implementation(libs.timber)

    implementation("org.bouncycastle:bcprov-jdk15to18:1.70")
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
}
