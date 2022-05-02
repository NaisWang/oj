package acwing;

import java.util.*;

public class Main3 {
  
  private static int N;
  private static int V;
  private static int[] v = null;
  private static int[] w = null;

  public static void main(String[] args) {
    input();
    Solution3 solution = new Solution3();
    System.out.println(solution.solution(N, V, v, w));
  }

  public static void input() {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    V = scan.nextInt();
    v = new int[N+1];
    w = new int[N+1];
    for(int i =1; i <= N; i++) {
      v[i] = scan.nextInt(); 
      w[i] = scan.nextInt();
    }
  }
  

}

class Solution3 {

  public int solution(int N, int V, int[] v, int[] w) {
    int[] dp = new int[V+1];
    for (int i = 1; i <= N; i++) {
      for (int j = v[i]; j <= V; j++) {
        dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
      }
    }
    return dp[V]; 
  }
  
}

class Solution3_1 {

  public int solution(int N, int V, int[] v, int[] w) {
    return dfs(N, V, v, w);
  }
  
  private int dfs(int nowN, int nowV, int[] v, int[] w) {
    if (nowN == 1) {
      return nowV / v[1] * w[1];
    }
    int maxNum = nowV / v[nowN];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= maxNum; i++) {
      max = Math.max(max, dfs(nowN - 1, nowV - i * v[nowN], v, w) + i * w[nowN]);
    }
    return max;
  }
  
}

class Solution3_2 {

  private Integer[][] dp = null;

  public int solution(int N, int V, int[] v, int[] w) {
    dp = new Integer[N + 1][V + 1];
    return dfs(N, V, v, w);
  }
  
  private int dfs(int nowN, int nowV, int[] v, int[] w) {
    if (nowN == 1) {
      return nowV / v[1] * w[1];
    }
    int maxNum = nowV / v[nowN];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= maxNum; i++) {
      if (dp[nowN - 1][nowV - i * v[nowN]] == null) {
        dp[nowN - 1][nowV - i * v[nowN]] = dfs(nowN - 1, nowV - i * v[nowN], v, w); 
      } 
      max = Math.max(max, dp[nowN - 1][nowV - i * v[nowN]] + i * w[nowN]);
    }
    return max;
  }
  
}


class Solution3_3 {

  private int[][] dp;

  public int solution(int N, int V, int[] v, int[] w) {
    dp = new int[N + 1][V + 1];
    for (int nowN = 1; nowN <= N; nowN++) {
      for (int nowV = 0; nowV <= V; nowV++) {
        if (nowV < v[nowN]) {
          dp[nowN][nowV] = dp[nowN - 1][nowV];
        } else {
          dp[nowN][nowV] = Math.max(dp[nowN - 1][nowV], dp[nowN][nowV -v[nowN]] + w[nowN]);
        }
      }
    }
    return dp[N][V];
  }
  
}
