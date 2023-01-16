package com.yzzzzun.playground.advanced.app.v2

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.logtrace.ThreadLocalLogTrace
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV2(val trace: ThreadLocalLogTrace) {

    fun save(itemId: String) {
        lateinit var status: TraceStatus;

        try {
            status = trace.begin("OrderRepository.save()")
            if (itemId == "ex") {
                throw IllegalStateException("예외 발생")
            }
            sleep(1000)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }

    }

    private fun sleep(millis: Long) {
        Thread.sleep(millis)
    }
}
