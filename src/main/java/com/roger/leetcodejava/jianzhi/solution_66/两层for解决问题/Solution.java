package com.roger.leetcodejava.jianzhi.solution_66.两层for解决问题;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/6 7:37 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] ints = constructArr(new int[] {1, 2, 3, 4, 5});
    System.out.println(ints);
  }

  /**
   * 当前算法时间复杂度为n^2.
   * @param a
   * @return
   */
  public int[] constructArr(int[] a) {
    int[] result = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      int currentMulti = 1;
      for (int j = 0; j < a.length; j++) {
        if (j != i) {
          currentMulti *= a[j];
        }
      }
      result[i] = currentMulti;
    }
    return result;
  }
}
