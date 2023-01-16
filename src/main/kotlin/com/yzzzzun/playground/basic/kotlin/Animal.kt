package com.yzzzzun.playground.basic.kotlin

abstract class Animal(protected val species: String, protected open val legCount: Int) {
    abstract fun move();
}
