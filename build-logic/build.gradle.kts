plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
//    implementation(libs.plugins.multiplatform.toDep())
//    implementation(libs.plugins.compose.compiler.toDep())
//    implementation(libs.plugins.compose)
    implementation(libs.gradle)
//    implementation(libs.kover.gradle.plugin)
    implementation(libs.com.google.devtools.ksp.gradle.plugin)
//    implementation(libs.detekt.gradle.plugin)
}

fun Provider<PluginDependency>.toDep() = map {
    "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}"
}

gradlePlugin {
    plugins {
        register("kmmCompose") {
            id = "kangaroo.plugin.kmm"
            // package add class name here
            implementationClass = "plugins.KMMPlugin"
        }
    }
}