package com.yzzzzun.playground.basic.java;

public interface Swimable {
	default void act() {
		System.out.println("swim");
	}
}
