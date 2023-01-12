import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    id("app.cash.zipline")
}

dependencies {
    implementation("app.cash.zipline:zipline:0.9.13")
    implementation("app.cash.zipline:zipline-loader:0.9.13")
    implementation(project(":leaky-flow-shared"))
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}

val shadowJar by tasks.getting(ShadowJar::class) {
    manifest {
        attributes("Main-Class" to "app.cash.zipline.samples.leakyflow.LeakyFlowJvmKt")
    }
}
