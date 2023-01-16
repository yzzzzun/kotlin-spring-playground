package com.yzzzzun.playground.advanced.app.v2

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.logtrace.ThreadLocalLogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV2(val orderRepository: OrderRepositoryV2, val trace: ThreadLocalLogTrace) {

    fun orderItem(itemId: String) {
        lateinit var status: TraceStatus

        try {
            status = trace.begin("OrderService.orderItem()")
            orderRepository.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

}
