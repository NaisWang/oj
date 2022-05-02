package leetcode;

import java.util.*;

public class Main208 {
  
}

class Trie {

  private Map<Integer, Map<Character, Integer>> transfer = new HashMap();
  // 存储‘接受状态’
  private List<Integer> acceptState = new ArrayList();
  private int stateCount = 0;
  
  public Trie() {
    transfer.put(0, new HashMap<Character, Integer>());
    stateCount ++;
  }

  public void insert(String word) {
    int length = word.length();
    Integer state = 0;
    for (int i = 0; i < length; i++) {
      char ch = word.charAt(i);
      if (!transfer.get(state).containsKey(ch)) {
        transfer.put(state, new HashMap<Character, Integer>(){{
          put(ch, ++stateCount);
        }});
        if (i == length -1) {
          acceptState.add(stateCount);
        }
      } else {
        state = tranfer.get(state).get(ch);
      }
    }
    
  }

  public boolean search(String word) {
    int length = word.length();
    Integer state = 0;
    for (int i = 0; i < length; i++) {
      char ch = word.charAt(i);
      if (!transfer.get(state).containsKey(ch)) {
        return false;
      } else {
        state = tranfer.get(state).get(ch);
      }
    }
    return acceptState.contains(state);
  }

  public boolean startsWith(String prefix) {
    int length = prefix.length();
    Integer state = 0;
    for (int i = 0; i < length; i++) {
      char ch = prefix.charAt(i);
      if (!transfer.get(state).containsKey(ch)) {
        return false;
      } else {
        state = tranfer.get(state).get(ch);
      }
    }
    return true;
  }
}

