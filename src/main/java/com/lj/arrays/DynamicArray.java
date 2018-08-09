package com.lj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DynamicArray {

	public static void main(String[] args) {
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		List<Integer> temp2 = new ArrayList<>();
		List<Integer> temp3 = new ArrayList<>();
		List<Integer> temp4 = new ArrayList<>();
		List<Integer> temp5 = new ArrayList<>();
		temp.addAll(Arrays.asList(1, 0, 5));
		temp2.addAll(Arrays.asList(1, 1, 7));
		temp3.addAll(Arrays.asList(1, 0, 3));
		temp4.addAll(Arrays.asList(2, 1, 0));
		temp5.addAll(Arrays.asList(2, 1, 1));
		queries.add(temp);
		queries.add(temp2);
		queries.add(temp3);
		queries.add(temp4);
		queries.add(temp5);

		List<Integer> answers = dynamicArrays(2, queries);
	}

	public static List<Integer> dynamicArrays(int n, List<List<Integer>> queries) {
		int lastAnswer = 0;
		List<Integer> result = new LinkedList<>();
		List<List<Integer>> seq = new ArrayList<>();
		int tempInsert;
		for (int i = 0; i < n; i++) {
			seq.add(new LinkedList<>());
		}
		for (List<Integer> row : queries) {
			tempInsert = (row.get(1) ^ lastAnswer) % n;
			lastAnswer = doQuery(row.get(0), tempInsert, row.get(2), seq);
			if (lastAnswer != 0) {
				result.add(lastAnswer);
			}
		}

		return result;

	}

	private static Integer doQuery(int type, int insert, int y, List<List<Integer>> seq) {
		List<Integer> insertSeq = seq.get(insert);
		if (type == 1) {
			insertSeq.add(y);
			return 0;
		} else {
			return insertSeq.remove(y % insertSeq.size());
		}
	}

}
