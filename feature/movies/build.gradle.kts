import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
//    id("kmp-library-plugin")
    alias(libs.plugins.kangaroo.plugin.kmm)
}

kotlin {
//    androidTarget {
//        compilations.all {
//            compileTaskProvider {
//                compilerOptions {
//                    jvmTarget.set(JvmTarget.JVM_1_8)
//                    //https://jakewharton.com/gradle-toolchains-are-rarely-a-good-idea/#what-do-i-do
//                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_1_8}")
//                }
//            }
//        }
//        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
//    }

    jvm()

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach { iosTarget ->
//        iosTarget.binaries.framework {
//            baseName = "ComposeApp"
//            isStatic = true
//        }
//    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // navigation
            implementation(libs.voyager.navigator)

            // koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            implementation(project(":domain"))
            implementation(project(":platform"))
        }
    }
}