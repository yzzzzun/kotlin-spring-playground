package com.yzzzzun.playground.basic.java;

public interface Flyable {
	default void act() {
		System.out.println("fly");
	}
}
