package coreplugins

object BuildPlugins {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${deps.versions.GradleVersions.androidGradleVersion}"
    const val androidKotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${deps.versions.KtServices.kotlinVersion}"
    const val absoluteRawKotlin =  "org.jetbrains.kotlin:kotlin-stdlib:${deps.versions.KtServices.kotlinVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"

    const val navSafeArgsPlugin = "androidx.navigation.safeargs.kotlin"

    // Firebase
    const val firebasePlugin = "com.google.gms.google-services"

}
