package app.cash.zipline.samples.leakyflow

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface LeakyService : ZiplineService {

    fun stream(): Flow<String>
}
