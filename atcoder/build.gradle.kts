import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// バージョンについてはこちら
// https://qiita.com/nak435/items/2cab8cc9918017b9564b

plugins {
    kotlin("jvm") version "1.5.21"
}

dependencies {
    testImplementation(project(":testutil"))
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.20.2")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.5.1")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    apiVersion = "1.3"
    languageVersion = "1.3"
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.release.set(11)
}
