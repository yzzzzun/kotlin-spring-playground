package com.yzzzzun.playground.advanced.trace.hellotrace

import com.yzzzzun.playground.advanced.trace.TraceId
import com.yzzzzun.playground.advanced.trace.TraceStatus
import mu.KotlinLogging
import org.springframework.stereotype.Component


@Component
class LogTraceV1 {

    private val logger = KotlinLogging.logger {}

    private val START_PREFIX: String = "-->";
    private val COMPLETE_PREFIX: String = "<--";
    private val EX_PREFIX: String = "<X-";

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis();
        logger.info("[{}] {}{}", traceId.id, addSpace(START_PREFIX, traceId.level), message)
        return TraceStatus(traceId, startTimeMs, message);
    }

    fun end(status: TraceStatus, e: Exception? = null) = complete(status, e)

    fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId
        if (e == null) {
            logger.info("[{}] {}{} time={}ms", traceId.id, addSpace(COMPLETE_PREFIX, traceId.level), status.message, resultTimeMs);
        } else {
            logger.info("[{}] {}{} time={}ms ex={}", traceId.id, addSpace(EX_PREFIX, traceId.level), status.message, resultTimeMs, e.toString());
        }
    }

    fun addSpace(prefix: String, level: Int) {
        val sb = StringBuilder()
        for (i in 0..level) {
            sb.append(if (i == level - 1) "|${prefix}" else "|    ")
        }
        sb.toString()
    }
}
