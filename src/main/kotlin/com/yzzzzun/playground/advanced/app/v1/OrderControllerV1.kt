package com.yzzzzun.playground.advanced.app.v1

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.hellotrace.LogTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV1(val trace: LogTraceV1, val orderService: OrderServiceV1) {
    @GetMapping("/v1/order")
    fun request(@RequestParam itemId: String): String {

        lateinit var status: TraceStatus

        try {
            status = trace.begin("OrderController.request()")
            orderService.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: Exception) {
            trace.end(status, e)
            throw e
        }
    }
}
