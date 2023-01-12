@file:OptIn(ExperimentalJsExport::class)

package app.cash.zipline.samples.leakyflow

import app.cash.zipline.Zipline

@JsExport
fun launchZipline() {
    val zipline = Zipline.get()
    zipline.bind<LeakyService>("leakyService", RealLeakyService())
}
