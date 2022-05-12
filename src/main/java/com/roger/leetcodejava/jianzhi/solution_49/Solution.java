package com.roger.leetcodejava.jianzhi.solution_49;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/11 9:16 PM
 */
public class Solution {
  /**
   * 注意:
   *
   * <p>特殊情况case : 千万不能忘记去重的问题比如 [0, 1, 2, 3, 4, 5, 6, 6, 8, 9, 10]
   */
  public int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int factor2 = 1, factor3 = 1, factor5 = 1;
    for (int i = 2; i <= n; i++) {
      int dp2 = dp[factor2] * 2;
      int dp3 = dp[factor3] * 3;
      int dp5 = dp[factor5] * 5;
      dp[i] = Math.min(Math.min(dp2, dp3), dp5);
      /** 注意这里都是if 不是if else 即没如果当前的是6 那么factor2 和factor3 都是会++的。 */
      if (dp[i] == dp2) {
        factor2++;
      }
      if (dp[i] == dp3) {
        factor3++;
      }
      if (dp[i] == dp5) {
        factor5++;
      }
    }
    return dp[n];
  }

  @Test
  public void test() {
    System.out.println(nthUglyNumber(10));
  }
}
