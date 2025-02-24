plugins {
    alias(libs.plugins.onestep.android.application)
    alias(libs.plugins.onestep.android.hilt)
    alias(libs.plugins.onestep.android.application.compose)
}

android {
    namespace = "com.colddelight.onestep"

    defaultConfig {
        applicationId = "com.colddelight.onestep"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:home"))
    implementation(project(":feature:exercise"))
    implementation(project(":feature:exercisedetail"))

    implementation(project(":feature:routine"))
    implementation(project(":feature:history"))
    implementation(project(":feature:login"))

    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.hilt.ext.work)
    implementation(libs.androidx.work.ktx)

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")

}