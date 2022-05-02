package acwing;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Main93 {
  
  private static Integer n = null;
  private static Integer m = null;

  public static void main(String[] args) {
    initInput();
    dfs(1, new LinkedList<>());
  }
  
  public static void initInput() {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt(); 
    m = scan.nextInt(); 
  }
  
  public static void dfs(Integer num, List<Integer> ans) {
    if (ans.size() == m) {
      System.out.println(ans.toString().replace("[", "").replace("]", "").replace(",", ""));
      return; 
    }
    if (num == n + 1) {
      return;
    }
    ans.add(num++);
    dfs(num, ans);
    ans.remove(ans.size() - 1);
    dfs(num, ans);
  }
  
}
