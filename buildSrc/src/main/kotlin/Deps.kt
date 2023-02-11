object Versions {
    /*Class Paths*/
    const val gradle = "7.3.1"
    const val kotlinGradle = "1.7.22"
    const val mapsPlatform = "2.0.1"

    /*Android - Ktx*/
    const val androidCore = "1.9.0"
    const val lifeCycle = "2.5.1"

    /*Compose*/
    const val activity = "1.6.1"
    const val composeUi = "1.3.3"
    const val composeMaterial = "1.3.1"

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


    val implementation = listOf(
        core,
        lifeCycle
    )
}

object Compose {
    private const val activity = "androidx.activity:activity-compose:${Versions.activity}"
    private const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    private const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"

    val implementation = listOf(
        activity,
        composeUi,
        toolingPreview,
        composeMaterial
    )
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
    private const val composeManifestTests = "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"
    val debugImplementation = listOf(
        composeUiToolingTests,
        composeManifestTests
    )
}
