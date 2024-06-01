plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")
    id("androidx.room")
    kotlin("plugin.serialization") version "2.0.0-RC3"
}

android {
    namespace = "com.example.pagingscreen"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pagingscreen"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    implementation(Dependencies.kotlin_serializer)
    implementation(Dependencies.kotlin)
    implementation (Dependencies.gson)
    implementation(Dependencies.hilt)
    kapt(Dependencies.hilt_kapt)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter)
    kapt(Dependencies.room)
    implementation(Dependencies.room_ktx)
    implementation(Dependencies.room_paging)
    kapt(Dependencies.life_cycle_kapt)
    implementation(Dependencies.life_cycle)
    implementation(Dependencies.view_model)
    implementation(Dependencies.saved_state_view_model)
    implementation(Dependencies.paging)
    testImplementation(Dependencies.paging_test)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.coroutine_core)
    implementation(Dependencies.coroutine_android)
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glide_annotation_processor)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.kotlin_testing)
    testImplementation(Dependencies.paging_testing)
}