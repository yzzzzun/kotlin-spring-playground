package com.yzzzzun.playground.advanced.app.v1

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.hellotrace.LogTraceV1
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV1(val trace: LogTraceV1) {

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
            trace.end(status, e)
            throw e
        }

    }

    private fun sleep(millis: Long) {
        Thread.sleep(millis)
    }
}
