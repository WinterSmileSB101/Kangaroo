package ext

import org.gradle.api.artifacts.VersionCatalog

internal fun VersionCatalog.koinCoreDependency() = findLibrary("koin-core").get()

internal fun VersionCatalog.koinAnnotationsDependency() = findLibrary("koin-annotations").get()

internal fun VersionCatalog.koinComposeViewModelDependency() =
    findLibrary("koin-compose-viewmodel").get()

internal fun VersionCatalog.koinComposeDependency() = findLibrary("koin-compose").get()

internal fun VersionCatalog.koinCoroutines() = findLibrary("koin-coroutines").get()

internal fun VersionCatalog.koinCompiler() = findLibrary("koin-compiler").get()

internal fun VersionCatalog.kmpMultiplatform() = findLibrary("multiplatform")

internal fun VersionCatalog.kmpComposeCompiler() = findLibrary("compose-compiler")

internal fun VersionCatalog.kmpCompose() = findLibrary("compose")
