package com.roger.leetcodejava.jianzhi.solution_16.迭代;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/8 9:07 AM
 */
public class Solution {
  /**
   * 实现 类似 Math.pow函数 这个递归搞不明白哭
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    /** 异常case判断 */
    if (n == 0) {
      return 0;
    }
    double result = 1;
    double currentMul = x;
    while (n > 0) {
      if (n % 2 == 1) {
        result *= currentMul;
      }
      currentMul *= currentMul;
      n = n >> 1;
    }
    return result;
  }

  @Test
  public void test() {
    System.out.println(myPow(2, 10));
  }
}
