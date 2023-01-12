plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("app.cash.zipline")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("app.cash.zipline:zipline:0.9.13")
                implementation(project(":leaky-flow-shared"))
            }
        }
    }
}


zipline {
    mainFunction.set("app.cash.zipline.samples.leakyflow.launchZipline")
}
