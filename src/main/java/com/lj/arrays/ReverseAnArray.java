package com.lj.arrays;

// this class is used to solve the problem
// https://www.hackerrank.com/challenges/arrays-ds/problem
public class ReverseAnArray {
	static int[] reverseArray(int[] a) {
		int[] reverse = new int[a.length];
		for(int i = a.length-1; i >= 0; i--) {
			reverse[a.length-1-i] = a[i];
		}
		return reverse;
	}
}
