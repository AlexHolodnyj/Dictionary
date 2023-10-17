plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //ksp for room
    id("com.google.devtools.ksp") version ("1.9.10-1.0.13")

    //calling view by name without findByViewId
    id("kotlin-parcelize")

    //navigationListener
    id("androidx.navigation.safeargs.kotlin") version ("2.7.2")
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.7.2"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

android {
    namespace = "com.example.dictionary"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dictionary"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        viewBinding = true
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //ROOM
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:${roomVersion}")
    implementation("androidx.room:room-ktx:${roomVersion}")
    annotationProcessor("androidx.room:room-compiler:${roomVersion}")
    ksp ("androidx.room:room-compiler:${roomVersion}")

    //Navigation Component
    val navVersion = "2.7.2"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //Lifecycle components
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //Kotlin components
    val kotlinVersion = "1.7.3"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${kotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinVersion}")

    //Gson
    implementation ("com.google.code.gson:gson:2.10.1")





}