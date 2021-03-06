// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {

      classpath(coreplugins.BuildPlugins.androidGradlePlugin)
      classpath(coreplugins.BuildPlugins.androidKotlinPlugin)
      classpath(deps.implementations.Framework.firebaseServices)
      classpath(deps.implementations.Framework.firebaseCrashlytics) // for monitoring & analysing crashes in firebase console
      classpath(deps.implementations.Framework.navSafeArgs)  // do not remove it, this isn't a mistake
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven("https://jitpack.io")
  }
}

tasks.register("clean").configure {
  delete(rootProject.buildDir)
}
