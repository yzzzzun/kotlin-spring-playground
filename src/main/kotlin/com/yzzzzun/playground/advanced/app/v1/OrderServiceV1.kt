package com.yzzzzun.playground.advanced.app.v1

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.hellotrace.LogTraceV1
import org.springframework.stereotype.Service

@Service
class OrderServiceV1(val orderRepository: OrderRepositoryV1, val trace: LogTraceV1) {

    fun orderItem(itemId: String) {
        lateinit var status: TraceStatus

        try {
            status = trace.begin("OrderService.orderItem()")
            orderRepository.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.end(status, e)
            throw e
        }
    }

}
