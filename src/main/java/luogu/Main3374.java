package luogu;

import java.util.*;

public class Main3374 {
	public static void main(String[] args) {
		int n, m;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int[] f = new int[n + 1];
		Solution3374 sol = new Solution3374(f, n);
		for (int i = 1; i <= n; i++) {
			f[i] = scan.nextInt();
			sol.update(i, f[i]);
		}
		while (m-- != 0) {
			int type = scan.nextInt();
			int x = scan.nextInt();
			if (type == 1) {
				int k = scan.nextInt();
				sol.update(x, k);
			} else {
				int y = scan.nextInt();
				System.out.println(sol.read(y) - sol.read(x - 1));
			}
		}
	}
}

class Solution3374 {

	private int[] tree = null;
	private int[] f = null;
	private int MaxVal;

	public Solution3374(int[] f, int MaxVal) {
		this.f = f;
		this.MaxVal = MaxVal;
		this.tree = new int[MaxVal + 1];
		//build();
	}

	private int lowbit(int x) {
		return x & -x;
	}

	private void build() {
		for (int idx = 1; idx <= MaxVal; idx++) {
			for (int j = idx - lowbit(idx) + 1; j <= idx; j++) {
				tree[idx] += f[j];
			}
		}
	}

	public void update(int idx, int val) {
		while (idx <= MaxVal) {
			tree[idx] += val;
			idx += lowbit(idx);
		}
	}

	public int read(int idx) {
		int sum = 0;
		while (idx > 0) {
			sum += tree[idx];
			idx -= lowbit(idx);
		}
		return sum;
	}

}
