package leetcode;

import java.util.*;

public class Main198 {
	public static void main(String args[]) {
		Solution198_4 so = new Solution198_4();
		System.out.println(so.rob(new int[]{1, 2, 3, 1, 3}));
	}
}


class Solution198 {

	private int length;

	public int rob(int[] nums) {
		length = nums.length;
		return dfs(-2, nums);
	}

	private int dfs(int now, int[] nums) {
		if (now >= length - 2) {
			return nums[now];
		}
		int maxNum = Integer.MIN_VALUE;
		for (int i = now + 2; i < length; i++) {
			maxNum = Math.max(maxNum, dfs(i, nums));
		}
		if (now == -2) return maxNum;
		return maxNum + nums[now];
	}

}


class Solution198_1 {

	private int[] dp = null;
	private int length;

	public int rob(int[] nums) {
		length = nums.length;
		dp = new int[length];
		initDp();
		return dfs(-2, nums);
	}

	private void initDp() {
		for (int i = 0; i < length; i++) {
			dp[i] = -1;
		}
	}

	private int dfs(int now, int[] nums) {
		if (now >= length - 2) {
			return nums[now];
		}
		int maxNum = Integer.MIN_VALUE;
		for (int i = now + 2; i < length; i++) {
			if (dp[i] == -1) {
				dp[i] = dfs(i, nums);
			}
			maxNum = Math.max(maxNum, dp[i]);
		}
		if (now == -2) return maxNum;
		return maxNum + nums[now];
	}

}

class Solution198_2 {

	public int rob(int[] nums) {
		return dfs(nums.length - 1, nums);
	}

	private int dfs(int now, int[] nums) {
		if (now == 0) return nums[0];
		if (now == 1) return Math.max(nums[1], nums[0]);
		return Math.max(dfs(now - 1, nums), dfs(now - 2, nums) + nums[now]);
	}

}

class Solution198_3 {


	private int[] dp = null;

	public int rob(int[] nums) {
		int length = nums.length;
		dp = new int[length];
		initDp(length);
		return dfs(nums.length - 1, nums);
	}

	private void initDp(int length) {
		for (int i = 0; i < length; i++) {
			dp[i] = -1;
		}
	}

	private int dfs(int now, int[] nums) {
		if (now == 0) return nums[0];
		if (now == 1) return Math.max(nums[1], nums[0]);
		if (dp[now - 1] == -1) {
			dp[now - 1] = dfs(now - 1, nums);
		}
		if (dp[now - 2] == -1) {
			dp[now - 2] = dfs(now - 2, nums);
		}
		return Math.max(dp[now - 1], dp[now - 2] + nums[now]);
	}

}

class Solution198_4 {

	public int rob(int[] nums) {
		int length = nums.length;
		if (length == 0) return nums[0];
		if (length == 1) return Math.max(nums[0], nums[1]);
		int[] dp = new int[length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[length - 1];
	}

}
