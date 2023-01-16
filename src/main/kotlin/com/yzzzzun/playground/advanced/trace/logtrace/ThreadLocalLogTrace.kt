package com.yzzzzun.playground.advanced.trace.logtrace

import com.yzzzzun.playground.advanced.trace.TraceId
import com.yzzzzun.playground.advanced.trace.TraceStatus
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class ThreadLocalLogTrace(private val traceIdHolder: ThreadLocal<TraceId> = ThreadLocal()) : LogTrace {

    private val logger = KotlinLogging.logger {}

    companion object {
        private const val START_PREFIX: String = "-->";
        private const val COMPLETE_PREFIX: String = "<--";
        private const val EX_PREFIX: String = "<X-";
    }

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder.get()
        val startTimeMs = System.currentTimeMillis();
        logger.info("[{}] {}{}", traceId.id, addSpace(START_PREFIX, traceId.level), message)
        return TraceStatus(traceId, startTimeMs, message);
    }

    override fun end(status: TraceStatus) = complete(status)

    override fun exception(status: TraceStatus, e: Exception) = complete(status, e)

    private fun syncTraceId() {
        val traceId = traceIdHolder.get()
        traceIdHolder.set(traceId?.createNextId() ?: TraceId())
    }

    private fun complete(status: TraceStatus, e: Exception? = null) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId
        if (e == null) {
            logger.info("[{}] {}{} time={}ms", traceId.id, addSpace(COMPLETE_PREFIX, traceId.level), status.message, resultTimeMs);
        } else {
            logger.info("[{}] {}{} time={}ms ex={}", traceId.id, addSpace(EX_PREFIX, traceId.level), status.message, resultTimeMs, e.toString());
        }
    }

    private fun addSpace(prefix: String, level: Int): String {
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append(if (i == level - 1) "|${prefix}" else "|    ")
        }
        return sb.toString()
    }
}
