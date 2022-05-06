package com.roger.leetcodejava.jianzhi.solution_14;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/1 7:36 PM
 */
public class Solution {
  /**
   * 动态规划 给出n 然后n分解 比如 n=10 可以分解为 3 3 4 最后 3*3*4 = 36 输出36;
   *
   * @param n
   * @return
   */
  public int cuttingRope(int n) {
    /** 处理特殊case */
    if (n <= 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }
    /** 开启dp mode */
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i <= n; i++) {
      /** 此处要保证j从下标1开始到 i/2 因为是对称性的 比如 1+3 和 2+2 最后3+1其实 j的范围是 i/2 即可 */
      for (int j = 1; j <= (i / 2); j++) {
        /** 此处要保证 j 以及 i-j是俩下标。 */
        dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
      }
    }
    return dp[n];
  }

  @Test
  public void test() {
    Solution solution = new Solution();
    System.out.println(solution.cuttingRope(5));
  }
}
