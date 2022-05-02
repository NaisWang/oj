package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Main1046 {
	public static void main(String[] args) {
		System.out.println(new Solution1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
	}
}

class Solution1046 {
	private ArrayList<Integer> stonesHeap;

	private void swap(int index1, int index2) {
		int temp = stonesHeap.get(index1);
		stonesHeap.set(index1, stonesHeap.get(index2));
		stonesHeap.set(index2, temp);
	}

	private void heapfiy(int index) {
		int c1 = index * 2 + 1;
		int c2 = index * 2 + 2;
		int max = index;
		int heapSize = stonesHeap.size();
		if (c1 < heapSize && stonesHeap.get(max) < stonesHeap.get(c1)) {
			max = c1;
		}
		if (c2 < heapSize && stonesHeap.get(max) < stonesHeap.get(c2)) {
			max = c2;
		}
		if (max != index) {
			swap(max, index);
			heapfiy(max);
		}
	}

	private void buildHeap() {
		int heapSize = stonesHeap.size();

		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			heapfiy(i);
		}

	}

	private int remove() {
		int ans = stonesHeap.get(0);
		int heapSize = stonesHeap.size();
		stonesHeap.set(0, stonesHeap.get(heapSize - 1));
		stonesHeap.remove(heapSize - 1);
		heapfiy(0);
		return ans;
	}

	private void add(int val) {
		stonesHeap.add(val);
		int nowIndex = stonesHeap.size() - 1;
		while (nowIndex != 0) {
			int parentIndex = (nowIndex - 1) / 2;
			if (stonesHeap.get(parentIndex) < stonesHeap.get(nowIndex)) {
				swap(parentIndex, nowIndex);
				nowIndex = parentIndex;
			} else {
				return;
			}
		}
	}


	public int lastStoneWeight(int[] stones) {
		stonesHeap = new ArrayList(Arrays.stream(stones).boxed().collect(Collectors.toList()));
		buildHeap();
		int length = stones.length;
		while (stonesHeap.size() > 1) {
			System.out.println(stonesHeap);
			int firstStone = remove();
			int secondStone = remove();
			if (firstStone != secondStone) {
				add(firstStone - secondStone);
			}
		}
		return stonesHeap.size() == 0 ? 0 : stonesHeap.get(0).intValue();
	}
}


/**
 * complete by using PriorityQueue class
 */
class Solution1046_1 {
	PriorityQueue<Integer> priorityQueue = null;

	public int lastStoneWeight(int[] stones) {
		priorityQueue = new PriorityQueue(stones.length, (a, b) -> (Integer) b - (Integer) a);
		for (int i = 0; i < stones.length; i++) {
			priorityQueue.add(stones[i]);
		}

		while (priorityQueue.size() > 1) {
			int ans = priorityQueue.poll() - priorityQueue.poll();
			if (ans != 0) {
				priorityQueue.add(ans);
			}
		}

		return priorityQueue.size() == 0 ? 0 : priorityQueue.peek();
	}
}
