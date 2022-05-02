package acwing;

import java.util.*;

public class Main91 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] g = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        g[i][j] = scan.nextInt();
      }
    }
    System.out.println(dfs(0, g, new boolean[n], n));
  }

  public static int dfs(int now, int[][] g, boolean[] v, int n) {
    int temp = Integer.MAX_VALUE;
    boolean flag = true;
    for (int i = 1; i < n - 1; i++) {
      if (!v[i]) {
        flag = false;
        v[i] = true;
        temp = Math.min(temp, g[now][i] + dfs(i, g, v, n));
        v[i] = false;
      }
    }
    if (flag) {
      temp = g[now][n - 1];
    }
    return temp;
  }
}
