package com.roger.leetcodejava.jianzhi.solution_10;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/4/19 7:43 PM
 */
public class Solution {
  public int fib(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    return dp[n - 1];
  }

  @Test
  public void test() {
    Solution solution = new Solution();
    System.out.println(solution.fib(5));
  }
}
