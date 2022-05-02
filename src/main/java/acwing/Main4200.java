package acwing;

import java.util.*;

class Main4200 {
  public static int p1, p2, p3, p4, a, b;

  public static void main(String[] args) {
    input();
    int count = 0;
    for (int i = a; i <= b; i++) {
      if (i < p1 && i < p2 && i < p3 && i < p4) {
        count++; 
      }
    }
    System.out.println(count);
  }

  public static void input() {
    Scanner scan = new Scanner(System.in);
    p1 = scan.nextInt();
    p2 = scan.nextInt();
    p3 = scan.nextInt();
    p4 = scan.nextInt();
    a = scan.nextInt();
    b = scan.nextInt();
  }

}
