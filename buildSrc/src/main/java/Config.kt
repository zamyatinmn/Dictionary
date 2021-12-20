import org.gradle.api.JavaVersion

object Config {
    const val APP_ID = "com.geekbrains.dictionary"
    const val COMPILE_SDK = 31
    const val MIN_SDK = 21
    const val TARGET_SDK = 31
    val java_version = JavaVersion.VERSION_1_8

    const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object Releases {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}

object Kotlin {
    const val CORE = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"
    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_STD_LIB}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
}

object RxJava {
    const val JAVA = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA}"
    const val ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
    const val LIVEDATA = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.RX_LIVEDATA}"
}

object Dagger {
    const val CORE = "com.google.dagger:dagger-android:${Versions.DAGGER}"
    const val SUPPORT = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
    const val PROCESSOR = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
    const val COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
}

object Glide {
    const val CORE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
}

object Room {
    const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
}

object Koin {
    const val CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
    const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
}

object Retrofit {
    const val CORE = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_CORE}"
    const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_GSON}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.RETROFIT_LOG}"
    const val RX_JAVA2 = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.RETROFIT_RX_JAVA2}"
    const val COROUTINES = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES}"
}

object Design {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"
}

object Test {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}