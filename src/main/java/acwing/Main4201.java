package acwing;

import java.util.*;

class Main4201 {

  public static int n;
  public static int ans;

  public static void dfs(int i, int count, int num) {
    if (i == count) {
      if (num <= n) {
        ans++;
      }
      return;
    }
    
    dfs(i, count + 1, num * 10 + 1);
    dfs(i, count + 1, num * 10);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    int i = 0;
    int temp = n;
    while(temp != 0) {
      temp /= 10;
      i++;
    }
    dfs(i, 0, 0);
    System.out.println(ans - 1);
  }
  
}
