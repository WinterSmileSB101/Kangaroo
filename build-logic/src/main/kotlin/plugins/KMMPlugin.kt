package plugins

import com.android.build.gradle.LibraryExtension
import config.ConfigurationKeys
import ext.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KMMPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = ConfigurationKeys.sdkConfiguration.targetSdk
                testOptions.animationsDisabled = true
            }

            extensions.configure<KotlinMultiplatformExtension> {
                listOf(
                    iosX64(),
                    iosArm64(),
                    iosSimulatorArm64()
                ).forEach { iosTarget ->
                    iosTarget.binaries.framework {
                        baseName = ConfigurationKeys.APP_NAME
                        isStatic = true
                    }

                }

                androidTarget {
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = ConfigurationKeys.javaConfiguration.javaVmTarget
                        }
                    }
                }
            }

        }
    }
}