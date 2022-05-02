package acwing;

import java.util.*;

public class Main282 {
	private static int N;
	private static int[] w;

	public static void main(String[] args) {
		input();
		Solution282 solution = new Solution282();
		System.out.println(solution.solution(N, w));
	}

	private static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		w = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			w[i] = scan.nextInt();
		}
	}

}

class Solution282 {

	// w数组的前缀和
	private int[] preSum;

	public int solution(int N, int[] w) {
		preSum = new int[N + 1];
		initPreSum(N, w);
		return dfs(1, N, w);
	}

	private void initPreSum(int N, int[] w) {
		for (int i = 1; i <= N; i++) {
			preSum[i] = preSum[i - 1] + w[i];
		}
	}

	private int dfs(int leftBound, int rightBound, int[] w) {
		if (rightBound - leftBound == 1) {
			return w[leftBound] + w[rightBound];
		}
		if (rightBound - leftBound == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = leftBound; i < rightBound; i++) {
			min = Math.min(min, dfs(leftBound, i, w) + dfs(i + 1, rightBound, w) + (preSum[rightBound] - preSum[leftBound - 1]));
		}
		return min;
	}

}

