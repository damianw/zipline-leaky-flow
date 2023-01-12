plugins {
    id("app.cash.zipline") version "0.9.13" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
