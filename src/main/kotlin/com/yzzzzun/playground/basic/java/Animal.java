package com.yzzzzun.playground.basic.java;

public abstract class Animal {

	protected final String species;
	protected final int legCount;

	public Animal(String species, int legCount) {
		this.species = species;
		this.legCount = legCount;
	}

	abstract public void move();

	public String getSpecies() {
		return species;
	}

	public int getLegCount() {
		return legCount;
	}
}
