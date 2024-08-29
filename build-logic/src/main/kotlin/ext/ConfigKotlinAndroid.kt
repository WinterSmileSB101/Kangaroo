package ext

import com.android.build.api.dsl.CommonExtension
import config.ConfigurationKeys
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        compileSdk = ConfigurationKeys.sdkConfiguration.compileSdk

        defaultConfig {
            minSdk = ConfigurationKeys.sdkConfiguration.minSdk
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

        compileOptions {
            sourceCompatibility = ConfigurationKeys.javaConfiguration.version
            targetCompatibility = ConfigurationKeys.javaConfiguration.version
        }

        configureKotlin()

        namespace = ConfigurationKeys.APPLICATION_ID.plus(name)
    }
}

private fun Project.configureKotlin() {
    // Use withType to workaround https://youtrack.jetbrains.com/issue/KT-55947
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = ConfigurationKeys.javaConfiguration.javaVmTarget
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                // Enable experimental coroutines APIs, including Flow
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
        }
    }
}