package app.cash.zipline.samples.leakyflow

import app.cash.zipline.EventListener
import app.cash.zipline.Zipline
import app.cash.zipline.loader.LoadResult
import app.cash.zipline.loader.ManifestVerifier.Companion.NO_SIGNATURE_CHECKS
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient

fun getLeakyService(zipline: Zipline): LeakyService {
    return zipline.take("leakyService")
}

private object LeakEventListener : EventListener() {

    override fun serviceLeaked(zipline: Zipline, name: String) {
        super.serviceLeaked(zipline, name)
        System.err.println("Leaked: $name")
    }
}

suspend fun launchZipline(dispatcher: CoroutineDispatcher): Zipline {
    val manifestUrl = "http://localhost:8080/manifest.zipline.json"
    val loader = ZiplineLoader(
        dispatcher = dispatcher,
        manifestVerifier = NO_SIGNATURE_CHECKS,
        httpClient = OkHttpClient(),
        eventListener = LeakEventListener,
    )
    return when (
        val result = loader.loadOnce("leaky", manifestUrl)) {
        is LoadResult.Success -> result.zipline
        is LoadResult.Failure -> error(result.exception)
    }
}
