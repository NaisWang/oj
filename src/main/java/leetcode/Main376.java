package leetcode;

import java.util.*;

public class Main376 {
  public static void main(String[] args) {
    Solution376 so = new Solution376();
    System.out.println(so.exist(new char[][]{{'A','B', 'C', 'E'}, {'B', 'F', 'C', 'S'}, {'C', 'D', 'E', 'E'}}, "ABCCED"));
  }
}

class Solution376 {
  private int[] rowDirection = {-1, 1, 0, 0};
  private int[] columnDirection = {0, 0, -1, 1};
  
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          char temp = board[i][j];
          board[i][j] = '0';
          if (dfs(board, word, i, j, 1)) {
            return true;
          }
          board[i][j] = temp;
        }
      }
    }
    return false;
  } 

  public boolean dfs(char[][] board, String word, int row, int column, int index) {
    if (index == word.length()) {
      return true;
    }
    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = column + columnDirection[i];
      if (nextRow >= 0 && nextRow < board.length && nextColumn >= 0 && nextColumn < board[0].length) {
        if (word.charAt(index) == board[nextRow][nextColumn]) {
          index++;
          char temp = board[nextRow][nextColumn];
          board[nextRow][nextColumn] = '0';
          if (dfs(board, word, nextRow, nextColumn, index)) {
            return true;
          }
          index--; 
          board[nextRow][nextColumn] = temp;
        }
      }
    }
    return false;
  }
}
