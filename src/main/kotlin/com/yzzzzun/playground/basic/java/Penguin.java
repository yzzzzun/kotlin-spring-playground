package com.yzzzzun.playground.basic.java;

public class Penguin extends Animal implements Swimable, Flyable {

	private final int wingCount;

	public Penguin(String species) {
		super(species, 2);
		this.wingCount = 2;
	}

	@Override
	public void move() {
		System.out.println("팽귄 move");
	}

	@Override
	public int getLegCount() {
		return super.legCount + this.wingCount;
	}

	@Override
	public void act() {
		Swimable.super.act();
		Flyable.super.act();
	}
}
