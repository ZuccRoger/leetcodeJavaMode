package com.roger.leetcodejava.jianzhi.solution_40.大根堆;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: 骆佳俊
 * @date: 2022/5/10 7:54 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] arr = {
      3, 2, 1, 5, 6, 4, 213, 12, 312, 3, 5, 456, 6, 45, 87, 76, 867, 867, 8, 768, 76, 867, 8
    };
    int[] leastNumbers = getLeastNumbers(arr, 2);
    System.out.println(leastNumbers);
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    // 默认是小根堆，实现大根堆需要重写一下比较器。
    Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
    for (int num : arr) {
      if (pq.size() < k) {
        pq.offer(num);
      } else if (num < pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }
    int[] ints = pq.stream().mapToInt(Integer::intValue).toArray();
    return ints;
  }
}
