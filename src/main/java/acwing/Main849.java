package acwing;

import java.util.*;

public class Main849 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] distMap = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			distMap[x][y] = distMap[x][y] == 0 ? z : Math.min(distMap[x][y], z);
		}
		System.out.println(new Solution849().solution(n, distMap));
	}

}

class Solution849 {

	PriorityQueue<PointOfDistance> queue = new PriorityQueue(4);
	private int[] visit = null;
	private int[] minDistance = null;

	class PointOfDistance implements Comparable<PointOfDistance> {
		public int point;
		public int distance;

		public PointOfDistance(int point, int distance) {
			this.point = point;
			this.distance = distance;
		}

		@Override
		public int compareTo(PointOfDistance a) {
			return this.distance - a.distance;
		}

		public String toString() {
			return point + ": " + distance;
		}
	}

	public int solution(int n, int[][] distMap) {
		visit = new int[n + 1];
		minDistance = new int[n + 1];
		queue.add(new PointOfDistance(1, 0));
		minDistance[1] = 0;
		while (!queue.isEmpty()) {
			PointOfDistance a = queue.poll();
			if (visit[a.point] == 0) {
				visit[a.point] = 1;
				minDistance[a.point] = a.distance;
				if (a.point == n) {
					return a.distance;
				}
				for (int i = 1; i <= n; i++) {
					if (visit[i] == 0 && distMap[a.point][i] != 0) {
						queue.add(new PointOfDistance(i, minDistance[a.point] + distMap[a.point][i]));
					}
				}
			}
		}
		return -1;
	}

}
