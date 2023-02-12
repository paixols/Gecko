plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = AppConfig.appId
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildTools

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    Android.implementation.forEach { dependency -> implementation(dependency) }
    KotlinLibs.implementations.forEach { dependency -> implementation(dependency) }

    Network.implementations.forEach { dependency -> implementation(dependency) }
    Serialization.implementations.forEach { dependency -> implementation(dependency) }
    DependencyInjection.apply {
        kaptImplementations.forEach { dependency -> kapt(dependency) }
        implementations.forEach { dependency -> implementation(dependency) }
    }

    Testing.testImplementation.forEach { dependency -> implementation(dependency) }
}