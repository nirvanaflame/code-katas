package com.demo;

public class Main {

	public static void main(java.lang.String[] args) {
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
	}

	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("");
		}
		return (int) factorialUsingRecursion(n);
	}

	public long factorialUsingRecursion(int n) {
		if (n <= 2) {
			return n;
		}
		return n * factorialUsingRecursion(n - 1);
	}
}
