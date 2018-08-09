package com.lj.arrays;

// this class is used to solve the problem
// https://www.hackerrank.com/challenges/2d-array/problem
// this class also expands on the idea to allow all types of pattern
// not only the pattern specific on the challenge page 
public class FindPatternOnTwoDArray {

	static int findHighestSumOfPattern(int[][] searchGrid, boolean[][] pattern) {
		// since we are trying to find the greatestSum we start
		// by init as the smallest integer value
		int greatestSum = Integer.MIN_VALUE;
		int currentSum;
		for (int i = 0; i <= searchGrid.length - pattern.length; i++) {
			for (int j = 0; j <= searchGrid[0].length - pattern[0].length; j++) {
				currentSum = searchPattern(searchGrid, pattern, i, j);
				greatestSum = (currentSum > greatestSum) ? currentSum : greatestSum;
			}
		}
		return greatestSum;

	}

	private static int searchPattern(int[][] searchGrid, boolean[][] pattern, int startx, int starty) {
		int patx, paty, sum;
		patx = paty = sum = 0;
		for (int i = startx; i < startx + pattern.length; i++) {
			paty = 0;
			for (int j = starty; j < starty + pattern[0].length; j++) {
				sum += pattern[patx][paty] ? searchGrid[i][j] : 0;
				paty++;
			}
			patx++;
		}
		return sum;
	}
}
