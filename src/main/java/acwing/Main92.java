package acwing;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main92 {

  private static Integer n = null;

  public static void main(String[] args) {
    initInput();
    dfs(1, new LinkedList());
  }

  public static void initInput() {
    Scanner scan = new Scanner(System.in); 
    n = scan.nextInt();
  }

  public static void dfs(int num, List<Integer> ans) {
    if (num == n+1) {
      System.out.println(ans.toString().replace("[", "").replace("]", "").replace(",", ""));
      return;
    }
    ans.add(num++);
    dfs(num, ans);
    ans.remove(ans.size()-1);
    dfs(num, ans);
  }

}
