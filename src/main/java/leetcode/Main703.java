package leetcode;

import java.util.*;

public class Main703 {
  public static void main(String[] args) {
    KthLargest1 kthLargest = new KthLargest1(7, new int[]{-10,1,3,1,4,10,3,9,4,5,1});

    System.out.println(kthLargest.add(3));   // return 4
    System.out.println(kthLargest.add(2));   // return 5
    System.out.println(kthLargest.add(3));  // return 5
    System.out.println(kthLargest.add(1));   // return 8
    System.out.println(kthLargest.add(2));   // return 8
    System.out.println(kthLargest.add(4));   // return 8
    System.out.println(kthLargest.add(5));   // return 8

  }
}


class KthLargest {
  
  private int[] heapItem = null;
  private int k;

  private void swap(int index1, int index2) {
    int temp = heapItem[index1];
    heapItem[index1] = heapItem[index2];
    heapItem[index2] = temp;
  }

  private void heapfiy(int itemIndex) {
    int leftChild = itemIndex * 2 + 1;
    int rightChild = leftChild + 1;
    int minIndex = itemIndex;
    if (leftChild < k && heapItem[minIndex] > heapItem[leftChild]) {
      minIndex = leftChild;
    } 
    if (rightChild < k && heapItem[minIndex] > heapItem[rightChild]) {
      minIndex = rightChild;
    } 
    if (minIndex != itemIndex) {
      swap(minIndex, itemIndex);
      heapfiy(minIndex);
    } 
  }
  
  private void buildHeap(int[] nums) {
    for (int i = k / 2 - 1; i >= 0; i--) {
      heapfiy(i);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > heapItem[0]) {
        heapItem[0] = nums[i];
        heapfiy(0);
      } 
    }
  }

  public KthLargest(int k, int[] nums) {
    this.k = k;
    heapItem = new int[k]; 
    for (int i = 0; i < k; i++) {
      if (i < nums.length) {
        heapItem[i] = nums[i];
      } else {
        heapItem[i] = Integer.MIN_VALUE;
      } 
    }
    buildHeap(nums);
  }

  public int add(int val) {
    if (val > heapItem[0]) {
      heapItem[0] = val;
      heapfiy(0);
    }
    return heapItem[0];
  }

}


/**
 * Complete by using PriorityQueue class
*/
class KthLargest1 {

  PriorityQueue<Integer> priorityQueue = new PriorityQueue(); 

  public KthLargest1(int k, int[] nums) {
    for (int i = 0; i < k; i++) {
      if (i < nums.length) {
        priorityQueue.add(nums[i]);
      } else {
        priorityQueue.add(Integer.MIN_VALUE);
      }
    }
    for (int i = k; i < nums.length; i++) {
      if (priorityQueue.peek() < nums[i]) {
        Integer a = priorityQueue.remove();
        priorityQueue.add(nums[i]);
      }
    }
  }

  public int add(int val) {
    if (priorityQueue.peek() < val) {
      priorityQueue.poll();
      priorityQueue.add(val);
    } 
    return priorityQueue.peek();
  }

}
