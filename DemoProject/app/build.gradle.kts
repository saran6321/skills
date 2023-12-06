plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  kotlin("kapt")
  id("com.google.dagger.hilt.android")
  id("kotlin-parcelize")
}

// build script for groupie
buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
  }
}

android {
  namespace = "com.sample.demo"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.sample.demo"
    minSdk = 26
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    viewBinding = true
    compose = true
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
}

dependencies {
  implementation(project(":design2"))

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.10.0")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
  implementation("androidx.navigation:navigation-ui-ktx:2.7.2")

  //compose
  implementation("androidx.activity:activity-compose:1.8.1")
  implementation(platform("androidx.compose:compose-bom:2023.03.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  // Hilt
  implementation("com.google.dagger:hilt-android:2.44")
  kapt("com.google.dagger:hilt-android-compiler:2.44")
  kapt("androidx.hilt:hilt-compiler:1.0.0")

  // Rest Api Handling
  implementation("com.google.code.gson:gson:2.9.1")
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8")

  // Coroutine
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

  //glide
  implementation("com.github.bumptech.glide:glide:4.16.0")

  //room
  implementation("androidx.room:room-runtime:2.5.2")
  annotationProcessor("androidx.room:room-compiler:2.5.2")
  kapt("androidx.room:room-compiler:2.5.2")

  //groupie
  implementation("com.github.lisawray.groupie:groupie:2.10.1")
  implementation("com.github.lisawray.groupie:groupie-viewbinding:2.10.1")

}