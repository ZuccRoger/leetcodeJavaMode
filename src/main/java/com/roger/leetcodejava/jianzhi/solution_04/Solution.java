package com.roger.leetcodejava.jianzhi.solution_04;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/4/19 8:08 PM
 */
public class Solution {
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    int row = matrix.length;
    if (row == 0) {
      return false;
    }
    int column = matrix[0].length;
    boolean isFind = false;
    int currentRow = 0;
    int currentColumn = column - 1;
    while (currentRow < row && 0 <= currentColumn) {
      if (matrix[currentRow][currentColumn] > target) {
        currentColumn--;
      } else if (matrix[currentRow][currentColumn] < target) {
        currentRow++;
      } else if (matrix[currentRow][currentColumn] == target) {
        isFind = true;
        break;
      }
    }
    return isFind;
  }

  @Test
  public void test() {
    Solution solution = new Solution();
    int[][] matrix = {
      {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
      {3, 6, 9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };
    boolean numberIn2DArray = solution.findNumberIn2DArray(matrix, 25);
    System.out.println(numberIn2DArray);
  }
}
