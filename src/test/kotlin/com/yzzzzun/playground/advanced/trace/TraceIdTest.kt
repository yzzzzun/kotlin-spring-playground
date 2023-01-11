package com.yzzzzun.playground.advanced.trace

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class TraceIdTest : AnnotationSpec() {


    @Test
    fun `TraceId 생성 테스트`() {
        val traceId = TraceId()
        traceId.level shouldBe 0
        traceId.id shouldNotBe null
    }

    @Test
    fun `TraceId nextId 생성 테스트`() {
        val traceId = TraceId()
        val nextId = traceId.createNextId()
        nextId.level shouldBe traceId.level + 1
        nextId.id shouldBe traceId.id
    }

    @Test
    fun `TraceId prevId 생성 테스트`() {
        val traceId = TraceId("test", 3)
        val prevId = traceId.createPrevId()

        prevId.level shouldBe (traceId.level - 1)
        prevId.id shouldBe traceId.id
    }

}
