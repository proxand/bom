plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.proxbom"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.proxbom"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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

//noinspection UseTomlInstead
dependencies {
    implementation( project ("::bom"))

    implementation("androidx.core:core-ktx")
    implementation("androidx.appcompat:appcompat")
    implementation("com.google.android.material:material")
    implementation("androidx.activity:activity")
    implementation("androidx.constraintlayout:constraintlayout")
    implementation("androidx.fragment:fragment-ktx")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx")

    implementation("com.github.bumptech.glide:glide")
    implementation("com.github.ybq:Android-SpinKit")

    implementation("com.squareup.retrofit2:converter-gson")
    implementation("com.squareup.retrofit2:converter-moshi")
    implementation("com.squareup.okhttp3:logging-interceptor")

    implementation("com.orhanobut:hawk")
    implementation("com.github.florent37:viewanimator")
    implementation("jp.wasabeef:glide-transformations")



    implementation("com.intuit.sdp:sdp-android")



    implementation("com.google.dagger:hilt-android:2.55")
    ksp("com.google.dagger:hilt-android-compiler:2.55")

    implementation("androidx.room:room-ktx:2.7.2")
    ksp ("androidx.room:room-compiler:2.7.2")


    implementation(platform("com.google.firebase:firebase-bom:33.16.0"))
    implementation("com.google.firebase:firebase-config-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")

    implementation("io.github.rupinderjeet:kprogresshud")
    implementation("com.google.code.gson:gson")
    implementation("com.airbnb.android:lottie")
    implementation("com.facebook.shimmer:shimmer")
    implementation("com.tbuonomo:dotsindicator")
    implementation("com.github.arthenica:ffmpeg-kit")
    implementation("com.github.li-xiaojun:XPopup")
    implementation("com.github.skydoves:rainbow")

    implementation("androidx.media3:media3-exoplayer")
    implementation("androidx.media3:media3-exoplayer-dash")
    implementation("androidx.media3:media3-exoplayer-hls")
    implementation("androidx.media3:media3-ui")

    implementation("androidx.camera:camera-core")
    implementation("androidx.camera:camera-camera2")
    implementation("androidx.camera:camera-video")
    implementation("androidx.camera:camera-view")


    implementation("pl.droidsonroids.gif:android-gif-drawable")

}
