package com.demo.interview;

class A {
	private int value = 100;

	A() {
		print();
	}

	public void print() {
		System.out.println(value);
	}
}


class B extends A {
	private int value = 200;

	B() {
		print();
	}

	public void print() {
		System.out.println(value);
	}
}


public class Playtika {

	public static void main(String[] args) {
		new B();

	}

}