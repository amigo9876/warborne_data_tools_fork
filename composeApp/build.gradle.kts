
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig


plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

compose.resources {
    publicResClass = false
    packageOfResClass = "com.elkite.warborn.resources"
    generateResClass = auto
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }


    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.androidx.adaptive.layout)
            implementation(libs.androidx.adaptive)
            implementation(libs.androidx.adaptive.navigation)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.material3)
            implementation(libs.material3)

            implementation(libs.material.icons.core)

            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.bottomsheet)
            implementation(libs.voyager.screenmodel)
            implementation(libs.voyager.transition)
            implementation(libs.voyager.tab)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.napier)
            implementation(libs.kotlinx.datetime)
        }

        wasmJsMain.dependencies {
            implementation(libs.ktor.client.js)
            implementation(libs.kotlinx.browser)
            implementation(libs.wasm.adaptive)
            implementation(libs.wasm.adaptive.layout)
            implementation(libs.wasm.adaptive.navigation)
        }
    }
}


android {
    namespace = "com.elkite.warborn"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.elkite.warborn"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
