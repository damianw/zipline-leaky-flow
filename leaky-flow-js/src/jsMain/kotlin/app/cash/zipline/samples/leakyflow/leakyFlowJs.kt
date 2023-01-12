package app.cash.zipline.samples.leakyflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealLeakyService : LeakyService {

    override fun stream(): Flow<String> = flow {
        emit("Foo")
        delay(1000L)
        emit("Bar")
        delay(1000L)
        emit("Baz")
        delay(1000L)
    }
}
