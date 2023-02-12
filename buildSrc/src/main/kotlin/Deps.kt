object Versions {
    /*Class Paths*/
    const val gradle = "7.3.1"
    const val kotlinGradle = "1.6.10"
    const val mapsPlatform = "2.0.1"

    /*Android - Ktx*/
    const val androidCore = "1.9.0"
    const val lifeCycle = "2.5.1"
    const val appCompat = "1.6.1"

    /*Compose*/
    const val activity = "1.6.1"
    const val composeUi = "1.3.3"
    const val composeMaterial = "1.3.1"

    /*Network*/
    const val retrofit2 = "2.9.0"
    const val okhttp3 = "4.9.3"

    /*Serialization*/
    const val gson = "2.10.1"
    const val gsonConverter = "2.9.0"

    /* DI */
    const val dagger2 = "2.45"

    /*Testing*/
    const val jUnit4 = "4.13.2"
    const val testExt = "1.1.5"
    const val espressoCore = "3.5.1"

}

object AppClassPaths {
    private const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    private const val kotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradle}"
    private const val mapsPlatform =
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.mapsPlatform}"

    val classPaths = listOf(gradle, kotlinGradle, mapsPlatform)
}

object Android {
    private const val core = "androidx.core:core-ktx:${Versions.androidCore}"
    private const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    val implementation = listOf(
        core,
        lifeCycle
    )
}

object Compose {
    private const val activity = "androidx.activity:activity-compose:${Versions.activity}"
    private const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    private const val toolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    private const val composeMaterial =
        "androidx.compose.material:material:${Versions.composeMaterial}"

    val implementation = listOf(
        activity,
        composeUi,
        toolingPreview,
        composeMaterial
    )
}

object Network {
    private const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    private const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"

    val implementations = listOf(retrofit2, loggingInterceptor, okhttp3)
}

object Serialization {
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"
    private const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"

    val implementations = listOf(gson, gsonConverter)

}

object DependencyInjection {
    private const val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    private const val dagger2Kapt = "com.google.dagger:dagger-compiler:${Versions.dagger2}"

    val implementations = listOf(dagger2)
    val kaptImplementations = listOf(dagger2Kapt)
}

object Testing {
    private const val jUnit4 = "junit:junit:${Versions.jUnit4}"
    val testImplementation = listOf(
        jUnit4
    )

    private const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    private const val composeUiTests = "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"
    val androidTestImplementation = listOf(
        testExt,
        espressoCore,
        composeUiTests
    )

    private const val composeUiToolingTests = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
    private const val composeManifestTests =
        "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"
    val debugImplementation = listOf(
        composeUiToolingTests,
        composeManifestTests
    )
}
