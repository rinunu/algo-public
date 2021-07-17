// バージョンについてはこちら
// https://qiita.com/nak435/items/2cab8cc9918017b9564b

plugins {
    kotlin("jvm") version "1.3.71"
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(project(":testutil"))
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.20.2")

    testImplementation("org.junit.platform:junit-platform-launcher:1.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.7.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.release.set(11)
}
