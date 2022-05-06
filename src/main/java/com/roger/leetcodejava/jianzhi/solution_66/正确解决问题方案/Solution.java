package com.roger.leetcodejava.jianzhi.solution_66.正确解决问题方案;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/6 7:45 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] ints = constructArr(new int[] {1, 2, 3, 4, 5});
    System.out.println(ints);
  }

  /**
   * 这里采用了2个for循环 时间复杂度只有O(n);空间复杂度只有个常量级别的所以是O(1);
   *
   * @param a
   * @return
   */
  public int[] constructArr(int[] a) {
    int inputLength = a.length;
    int[] result = new int[inputLength];
    /** 把每个result[i]左边的乘集得到 */
    for (int i = 0, product = 1; i < inputLength; product *= a[i], i++) {
      result[i] = product;
    }
    /** 我的疑问: 为什么上面是=product 下面这里是*=product. */
    for (int i = inputLength - 1, product = 1; i >= 0; product *= a[i], i--) {
      result[i] *= product;
    }
    return result;
  }
}
