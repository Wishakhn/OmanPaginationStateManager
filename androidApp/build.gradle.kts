plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.oman_paginationstatemanager.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.oman_paginationstatemanager.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.koin.compose)
    api(platform(libs.androidx.compose.bom))
    implementation(libs.compose.util)
    implementation(libs.androidx.activity.compose)
}