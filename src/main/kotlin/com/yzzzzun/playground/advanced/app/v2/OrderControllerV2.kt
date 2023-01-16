package com.yzzzzun.playground.advanced.app.v2

import com.yzzzzun.playground.advanced.trace.TraceStatus
import com.yzzzzun.playground.advanced.trace.logtrace.ThreadLocalLogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV2(val trace: ThreadLocalLogTrace, val orderService: OrderServiceV2) {
    @GetMapping("/v2/order")
    fun request(@RequestParam itemId: String): String {

        lateinit var status: TraceStatus

        try {
            status = trace.begin("OrderController.request()")
            orderService.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}
