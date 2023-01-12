package app.cash.zipline.samples.leakyflow

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.system.exitProcess

fun main() {
    val executorService = Executors.newFixedThreadPool(1) {
        Thread(it, "Zipline")
    }
    val dispatcher = executorService.asCoroutineDispatcher()
    runBlocking(dispatcher) {
        val zipline = launchZipline(dispatcher)
        try {
            val leakyService = getLeakyService(zipline)
            try {
                leakyService
                    .stream()
                    .take(3)
                    .collect(::println)
            } finally {
                leakyService.close()
            }
        } finally {
            zipline.close()
        }
    }
    executorService.shutdown()
    exitProcess(0)
}
