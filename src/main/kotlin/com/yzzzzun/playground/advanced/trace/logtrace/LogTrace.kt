package com.yzzzzun.playground.advanced.trace.logtrace

import com.yzzzzun.playground.advanced.trace.TraceStatus

interface LogTrace {
    fun begin(message: String): TraceStatus
    fun end(status: TraceStatus)
    fun exception(status: TraceStatus, e: Exception)
}
