plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = Config.APP_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Releases.VERSION_CODE
        versionName = Releases.VERSION_NAME

        testInstrumentationRunner = Config.TEST_RUNNER
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Config.java_version
        targetCompatibility = Config.java_version
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Kotlin.STD_LIB)
    implementation(Kotlin.CORE)

    implementation(Kotlin.COROUTINES_CORE)
    implementation(Kotlin.COROUTINES_ANDROID)

    implementation(RxJava.JAVA)
    implementation(RxJava.ANDROID)
    implementation(RxJava.LIVEDATA)

    implementation(Dagger.CORE)
    implementation(Dagger.SUPPORT)
    kapt(Dagger.PROCESSOR)
    kapt(Dagger.COMPILER)

    implementation(Glide.CORE)
    kapt(Glide.COMPILER)

    implementation(Room.RUNTIME)
    implementation(Room.KTX)
    kapt(Room.COMPILER)

    implementation(Koin.CORE)
    implementation(Koin.ANDROID)

    implementation(Retrofit.CORE)
    implementation(Retrofit.GSON_CONVERTER)
    implementation(Retrofit.LOGGING_INTERCEPTOR)
    implementation(Retrofit.RX_JAVA2)
    implementation(Retrofit.COROUTINES)

    implementation(Design.APPCOMPAT)
    implementation(Design.MATERIAL)
    implementation(Design.CONSTRAINT)

    testImplementation(Test.JUNIT)
    androidTestImplementation(Test.JUNIT_EXT)
    androidTestImplementation(Test.ESPRESSO)
}