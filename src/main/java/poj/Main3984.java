package poj;

import java.util.*;

public class Main3984 {

	private static int[][] mapNums = new int[5][5];

	public static void main(String[] args) {
		input();
		Node node = new Solution3984().solution(mapNums);
		if (node != null) node.printPreNodeReversea();
		else {
			System.out.println("-1");
		}
	}

	private static void input() {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				mapNums[i][j] = scan.nextInt();
			}
	}

}


class Solution3984 {

	private int[] xDirection = {0, 0, -1, 1};
	private int[] yDirection = {-1, 1, 0, 0};

	public Node solution(int[][] mapNums) {
		List<Node> queue = new LinkedList();
		queue.add(new Node(0, new Point(0, 0), null));

		while (!queue.isEmpty()) {
			Node firstNode = queue.remove(0);
			Point nowCoordinate = firstNode.getCoordinate();
			for (int i = 0; i < 4; i++) {
				int nextX = nowCoordinate.x + xDirection[i];
				int nextY = nowCoordinate.y + yDirection[i];
				if (isSuccess(nextX, nextY)) {
					return new Node(firstNode.getStep() + 1, new Point(nextX, nextY), firstNode);
				}
				if (isArea(nextX, nextY) && mapNums[nextY][nextX] != 1 && mapNums[nextY][nextX] != -1) {
					mapNums[nextY][nextX] = -1;
					queue.add(new Node(firstNode.getStep() + 1, new Point(nextX, nextY), firstNode));
				}
			}
		}
		return null;
	}

	private boolean isSuccess(int x, int y) {
		if (x == 4 && y == 4) return true;
		return false;
	}

	private boolean isArea(int x, int y) {
		if (x < 0 || x > 4 || y < 0 || y > 4) return false;
		return true;
	}


}

class Node {
	private Integer step = null;
	private Point coordinate = null;
	private Node preNode = null;

	public Node(Integer step, Point coordinate, Node preNode) {
		this.step = step;
		this.coordinate = coordinate;
		this.preNode = preNode;
	}

	public void printPreNodeReversea() {
		LinkedList<Node> nodes = new LinkedList();
		Node node = this;
		while (node != null) {
			nodes.addFirst(node);
			node = node.getPreNode();
		}
		for (Node tempNode : nodes) {
			System.out.println(tempNode.getCoordinate());
		}
	}

	public Node getPreNode() {
		return preNode;
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public Integer getStep() {
		return step;
	}

}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + y + ", " + x + ")";
	}
}
