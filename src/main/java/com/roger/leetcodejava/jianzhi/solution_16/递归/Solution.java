package com.roger.leetcodejava.jianzhi.solution_16.递归;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/7 7:56 AM
 */
public class Solution {
  @Test
  public void test() {
    System.out.println(myPow(0.44528, 0));
  }

  /**
   * 因为 x^72次 = x^36 * x ^ 36 所以是一个递归的解决方案.
   *
   * <p>时间复杂度 O(logn)
   *
   * <p>空间复杂度 O(logn)
   *
   * <p>然后我们通过奇 和 偶 进行递归.
   */
  public double myPow(double x, int n) {
    /** 处理异常case */
    if (n == 0) {
      return 1;
    }
    long N = n;
    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
  }

  public double quickMul(double x, long N) {
    if (N == 1) {
      return x;
    }
    double result = quickMul(x, N / 2);
    return N % 2 == 1 ? result * result * x : result * result;
  }
}
