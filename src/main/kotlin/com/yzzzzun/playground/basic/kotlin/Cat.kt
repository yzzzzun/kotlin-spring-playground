package com.yzzzzun.playground.basic.kotlin

class Cat(species: String) : Animal(species, 4) {
    override fun move() {
        println("고양이 move")
    }
}
