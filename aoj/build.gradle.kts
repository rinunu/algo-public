import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// バージョン
// https://judge.u-aizu.ac.jp/onlinejudge/status_note.jsp?tab=2

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
    apiVersion = "1.1"
    languageVersion = "1.1"
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.release.set(11)
}
