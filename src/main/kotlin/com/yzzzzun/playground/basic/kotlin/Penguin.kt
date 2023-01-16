package com.yzzzzun.playground.basic.kotlin

class Penguin(species: String) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("팽귄 move")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount
}
