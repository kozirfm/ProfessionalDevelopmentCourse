import org.gradle.api.JavaVersion

object Config {
    const val application_id = "ru.kozirfm.professionaldevelopmentcourse"
    const val compile_sdk = 30
    const val min_sdk = 21
    const val target_sdk = 30
    const val build_tools_version = "30.0.3"
    val java_version = JavaVersion.VERSION_1_8
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"

    //Features
    const val historyScreen = ":historyScreen"
}

//object Versions {
    //Tools
//    const val multidex = "1.0.3"

    //Design
//    const val appcompat = "1.1.0-rc01"
//    const val material = "1.0.0"

    //Kotlin
//    const val core = "1.3.2"
//    const val stdlib = "1.4.21"
//    const val coroutinesCore = "1.2.1"
//    const val coroutinesAndroid = "1.1.1"

    //Retrofit
//    const val retrofit = "2.6.0"
//    const val converterGson = "2.6.0"
//    const val interceptor = "3.12.1"
//    const val adapterCoroutines = "0.9.2"

    //Koin
//    const val koinAndroid = "2.0.1"
//    const val koinViewModel = "2.0.1"

    //Glide
//    const val glide = "4.9.0"
//    const val glideCompiler = "4.9.0"

    //Picasso
//    const val picasso = "2.5.2"

    //Room
//    const val roomKtx = "2.2.0-alpha01"
//    const val runtime = "2.2.0-alpha01"
//    const val roomCompiler = "2.2.0-alpha01"

    //Test
//    const val jUnit = "4.12"
//    const val runner = "1.2.0"
//    const val espressoCore = "3.2.0"
//}


object Tools {
    const val multidex = "com.android.support:multidex:1.0.3"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:1.1.0-rc01"
    const val material = "com.google.android.material:material:1.0.0"
    const val swipe_refresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:1.3.2"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.21"
}

object Coroutines {
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:2.6.0"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:2.6.0"
    const val adapter_coroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:3.12.1"
}

object Koin {
    const val koin_android = "org.koin:koin-android:2.0.1"
    const val koin_view_model = "org.koin:koin-android-viewmodel:2.0.1"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:4.9.0"
    const val glide_compiler = "com.github.bumptech.glide:compiler:4.9.0"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:2.5.2"
}

object Room {
    const val runtime = "androidx.room:room-runtime:2.2.0-alpha01"
    const val compiler = "androidx.room:room-compiler:2.2.0-alpha01"
    const val room_ktx = "androidx.room:room-ktx:2.2.0-alpha01"
}

object TestImpl {
    const val junit = "junit:junit:4.12"
    const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
}