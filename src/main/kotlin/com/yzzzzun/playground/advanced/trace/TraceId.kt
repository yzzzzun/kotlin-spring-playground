package com.yzzzzun.playground.advanced.trace

import java.util.*

class TraceId(var id: String, var level: Int) {

    constructor() : this("", 0) {
        id = createId()
        level = 0
    }

    private fun createId(): String = UUID.randomUUID().toString().substring(0, 8)

    fun createNextId(): TraceId = TraceId(id, level + 1)
    fun createPrevId(): TraceId = TraceId(id, level - 1)
    fun isFirstLevel(): Boolean = level == 0
}
