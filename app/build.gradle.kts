plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = AppConfig.appId
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildTools

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            this.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}

dependencies {

    App.modules.forEach { module -> implementation(project(module)) }

    Android.implementation.forEach { dependency -> implementation(dependency) }
    KotlinLibs.implementations.forEach { dependency -> implementation(dependency) }
    Compose.implementation.forEach { dependency -> implementation(dependency) }

    Network.implementations.forEach { dependency -> implementation(dependency) }
    Serialization.implementations.forEach { dependency -> implementation(dependency) }
    DependencyInjection.apply {
        kaptImplementations.forEach { dependency -> kapt(dependency) }
        implementations.forEach { dependency -> implementation(dependency) }
    }

    Testing.testImplementation.forEach { dependency -> implementation(dependency) }
    Testing.androidTestImplementation.forEach { dependency -> androidTestImplementation(dependency) }
    Testing.debugImplementation.forEach { dependency -> debugImplementation(dependency) }
}