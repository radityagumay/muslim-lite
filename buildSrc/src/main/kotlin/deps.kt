/*
* Copyright 2019 RadityaLabs.
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

@file:Suppress("unused", "ClassName")

object versions {
    internal const val jacoco = "0.8.4"
    internal const val detekt = "1.1.1"

    internal const val kotlin = "1.3.60"
    internal const val navigation = "2.1.0-rc01"
    internal const val coroutines = "1.3.2"
    internal const val lifecycle = "2.0.0"
    internal const val retrofit = "2.6.2"
}

object deps {
    object java {
        const val inject = "javax.inject:javax.inject:1"
    }

    object android {
        const val gson = "com.google.code.gson:gson:2.8.6"
        const val benchmark = "androidx.benchmark:benchmark-junit4:1.0.0"

        object build {
            const val buildToolsVersion = "29.0.2"
            const val compileSdkVersion = 29
            const val minSdkVersion = 16
            const val sampleMinSdkVersion = 21
            const val targetSdkVersion = 29
        }

        object lifecycle {
            const val livedata = "androidx.lifecycle:lifecycle-livedata:${versions.lifecycle}"
            const val test = "androidx.arch.core:core-testing:${versions.lifecycle}"
        }

        object support {
            const val annotation = "androidx.annotation:annotation:1.1.0"
        }

        object core {
            const val coreKtx = "androidx.core:core-ktx:1.1.0"
        }

        object firebase {
            const val config = "com.google.firebase:firebase-config:17.0.0"
        }

        object room {
            const val room = "androidx.room:room-runtime:2.2.2"
            const val roomCompiler = "androidx.room:room-compiler:2.2.2"
            const val roomTesting = "androidx.room:room-testing:2.2.2"
        }

        object dagger {
            const val dagger = "com.google.dagger:dagger:2.25.2"
            const val compiler = "com.google.dagger:dagger-compiler:2.25.2"

            const val assisted = "com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2"
            const val assistedCompiler = "com.squareup.inject:assisted-inject-processor-dagger2:0.5.2"
        }

        object test {
            const val core = "androidx.test:core:1.2.0"
            const val junit = "junit:junit:4.12"
            const val roboelectric = "org.robolectric:robolectric:4.2"
            const val mockitoCore = "org.mockito:mockito-core:2.25.0"
            const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
        }
    }

    object kotlin {
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${versions.kotlin}"

        object stdlib {
            const val core = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
            const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${versions.kotlin}"
        }

        object coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.coroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${versions.coroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${versions.coroutines}"
        }
    }

    object rx {
        const val java = "io.reactivex.rxjava2:rxjava:2.2.15"
        const val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object detekt {
        const val lint = "io.gitlab.arturbosch.detekt:detekt-formatting:${versions.detekt}"
        const val cli = "io.gitlab.arturbosch.detekt:detekt-cli:${versions.detekt}"
    }

    object square {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.2.2"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.6.2"
        const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:2.6.2"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.9.2"
        const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:1.9.2"
    }
}
