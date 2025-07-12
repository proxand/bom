plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish") // Chỉ sử dụng maven-publish, bỏ java-platform
}

android {
    namespace = "com.prox.bom"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
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
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"]) // Fix lỗi component not found
                groupId = "com.prox"
                artifactId = "bom"
                version = "1.0.0"
            }
        }
    }
}

dependencies {
    constraints {
        //android app
        api("androidx.core:core-ktx:1.16.0")
        api("androidx.appcompat:appcompat:1.7.1")
        api("com.google.android.material:material:1.12.0")
        api("androidx.constraintlayout:constraintlayout:2.2.1")
        api("androidx.activity:activity:1.10.1")
        api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
        api("androidx.fragment:fragment-ktx:1.5.7")


        //network
        api("com.squareup.retrofit2:converter-gson:2.9.0")
        api("com.squareup.retrofit2:converter-moshi:2.9.0")
        api("com.squareup.okhttp3:logging-interceptor:4.9.0")

//        api("com.google.dagger:hilt-android:2.55")


        //database
        api("com.orhanobut:hawk:2.0.1")
//        api("androidx.room:room-ktx:2.7.2")

        //ui/ux
        api("com.intuit.sdp:sdp-android:1.1.1")
        api("com.github.bumptech.glide:glide:4.13.0")
        api("com.github.ybq:Android-SpinKit:1.4.0")
        api("com.github.florent37:viewanimator:v1.1.2")
        api("jp.wasabeef:glide-transformations:4.3.0")
        api("io.github.rupinderjeet:kprogresshud:1.0.0")
        api("com.google.code.gson:gson:2.12.1")
        api("com.airbnb.android:lottie:6.1.0")
        api("com.facebook.shimmer:shimmer:0.5.0@aar")

        api("com.tbuonomo:dotsindicator:5.1.0")
        api("com.github.arthenica:ffmpeg-kit:v5.1.LTS")
        api("com.github.li-xiaojun:XPopup:2.9.19")
        api("com.github.skydoves:rainbow:1.0.4")

        val exoVersion = "1.7.1"
        api("androidx.media3:media3-exoplayer:${exoVersion}")
        api("androidx.media3:media3-exoplayer-dash:${exoVersion}")
        api("androidx.media3:media3-exoplayer-hls:${exoVersion}")
        api("androidx.media3:media3-ui:${exoVersion}")

        val cameraxVersion = "1.3.0-alpha07"
        api("androidx.camera:camera-core:${cameraxVersion}")
        api("androidx.camera:camera-camera2:${cameraxVersion}")
        api("androidx.camera:camera-video:${cameraxVersion}")
        api("androidx.camera:camera-view:${cameraxVersion}")

        api("pl.droidsonroids.gif:android-gif-drawable:1.2.25")


    }


}

