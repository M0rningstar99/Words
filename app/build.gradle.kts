plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt") version "2.0.0"


}

android {
    namespace = "com.example.roomtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.roomtest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments = ["room.schemaLocation":
//                "$projectDir/schemas".toString()]
//            }
//        }


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    //导入room依赖
    val room_version = "2.5.1"

    implementation("androidx.room:room-runtime:$room_version")
    //kotlin
    kapt("androidx.room:room-compiler:$room_version")
    //java
//    annotationProcessor("androidx.room:room-compiler:$room_version")




    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")



    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}