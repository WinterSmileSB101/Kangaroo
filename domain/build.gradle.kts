@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    // TODO wait https://youtrack.jetbrains.com/issue/KT-70700/Gradle-8.10-The-value-for-task-commonizeNativeDistribution-property-kotlinNativeBundleBuildService-cannot-be-changed-any-further
//    id("kmp-library-plugin")
//    id("com.android.library")
    alias(libs.plugins.kangaroo.plugin.kmm)
//    id("koin-plugin-setup")
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            // koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
        }
        commonTest.dependencies {
//            implementation(libs.bundles.test.multiplatform)
        }
    }
}