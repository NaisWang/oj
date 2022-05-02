package acwing;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Main94 {

  private static Integer n = null;
  private static boolean[] flag = null; 

  public static void main(String[] args) {
    initInput();    
    flag = new boolean[n + 1];
    dfs(new LinkedList());
  } 

  public static void initInput() {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt(); 
  }
  
  public static void dfs(List<Integer> ans) {
    if (ans.size() == n) {
      System.out.println(ans.toString().replace(",", "").replace("[", "").replace("]", ""));
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (!flag[i]) {
        flag[i] = true;
        ans.add(i);
        dfs(ans);
        ans.remove(ans.size() - 1);
        flag[i] = false;
      }
    }
  }

}
