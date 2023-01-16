package com.yzzzzun.playground.basic.java;

public class Cat extends Animal {

	public Cat(String species) {
		super(species, 4);
	}

	@Override
	public void move() {
		System.out.println("고양이 move");
	}
}
