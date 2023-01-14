package com.yzzzzun.playground.advanced.trace.hellotrace

import io.kotest.core.spec.style.AnnotationSpec

class LogTraceV1Test : AnnotationSpec() {
    @Test
    fun `log trace begin end 출력 확인`() {
        val trace = LogTraceV1();
        val status = trace.begin("LogTraceV1");
        trace.end(status);
    }

    @Test
    fun `log trace begin exception 출력 확인`() {
        val trace = LogTraceV1();
        val status = trace.begin("LogTraceV1");
        trace.end(status, IllegalArgumentException("오류발생"));
    }
}
