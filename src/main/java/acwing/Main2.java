package acwing;

import java.util.*;

public class Main2 {

  private static int N;
  private static int V;
  private static int[] v = null;
  private static int[] w = null;

  public static void main(String[] args) {
    input();
    Solution2 solution = new Solution2();
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

class Solution2 {

  public int solution(int N, int V, int[] v, int[] w) {
    int[] dp = new int[V+1];
    for (int i = 1; i <= N; i++) {
      for (int j = V; j >= v[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
      }
    }
    return dp[V]; 
  }
  
}

class Solution2_3 {

  public int solution(int N, int V, int[] v, int[] w) {
    int[][] dp = new int[N+1][V+1];
    for (int nowN = 1; nowN <= N; nowN++) {
      for (int nowV = 0; nowV <= V; nowV++) {
        if (nowV < v[nowN]) {
          dp[nowN][nowV] = dp[nowN - 1][nowV];
        } else {
          dp[nowN][nowV] = Math.max(dp[nowN - 1][nowV - v[nowN]] + w[nowN], dp[nowN - 1][nowV]);
        }
      }
    }
    return dp[N][V]; 
  }
  
}

class Solution2_1 {

  public int solution(int N, int V, int[] v, int[] w) {
    return dfs(N, V, v, w);
  }

  private int dfs(int nowN, int nowV, int[] v, int[] w) {
    if (nowN == 1) {
      if (nowV >= v[1]) {
        return w[1];
      }
      return 0;
    } 

    int min = Integer.MIN_VALUE;
    if (nowV >= v[nowN] ) {
      min = dfs(nowN - 1, nowV - v[nowN], v, w) + w[nowN];
    }

    return Math.max(min, dfs(nowN - 1, nowV, v, w));
  }
  
}

class Solution2_2 {

  private Integer[][] dp = null; 

  public int solution(int N, int V, int[] v, int[] w) {
    dp = new Integer[N+1][V+1];
    return dfs(N, V, v, w);
  }

  private int dfs(int nowN, int nowV, int[] v, int[] w) {
    if (nowN == 1) {
      if (nowV >= v[1]) {
        return w[1];
      }
      return 0;
    } 
    if (nowV >= v[nowN] ) {
      if (dp[nowN - 1][nowV - v[nowN]] == null) {
        dp[nowN - 1][nowV - v[nowN]] = dfs(nowN - 1, nowV - v[nowN], v, w);
      }
    } 
    if (dp[nowN - 1][nowV] == null) {
      dp[nowN - 1][nowV] = dfs(nowN - 1, nowV, v, w);
    } 
    return Math.max(nowV >= v[nowN] ? dp[nowN - 1][nowV - v[nowN]] + w[nowN] : 0, dp[nowN - 1][nowV]);
  }
  
}
