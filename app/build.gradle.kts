plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.mikef.lastfm"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    // Room
    implementation("androidx.room:room-runtime:2.3.0")
    implementation("androidx.room:room-ktx:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")

    // AdapterDelegates
    implementation("com.hannesdorfmann:adapterdelegates4:4.3.0")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl:4.3.0")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:4.3.0")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:4.3.0")

    // Coroutines / Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

    // Network
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Image Loading
    implementation("io.coil-kt:coil:1.2.2")

    // Koin
    implementation("io.insert-koin:koin-core:3.1.2")
    implementation("io.insert-koin:koin-android:3.1.2")

    // Misc
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("io.coil-kt:coil:1.2.2")

    // Debug dependencies
    debugImplementation("com.facebook.flipper:flipper:0.96.1")
    releaseImplementation("com.facebook.flipper:flipper-noop:0.96.1")
    debugImplementation("com.facebook.flipper:flipper-network-plugin:0.96.1")
    debugImplementation("com.facebook.soloader:soloader:0.10.1")

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}