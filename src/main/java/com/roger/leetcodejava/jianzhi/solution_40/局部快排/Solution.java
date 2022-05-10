package com.roger.leetcodejava.jianzhi.solution_40.局部快排;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: 骆佳俊
 * @date: 2022/5/10 7:36 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] ints = {
      3, 2, 1, 5, 6, 4, 213, 12, 312, 3, 5, 456, 6, 45, 87, 76, 867, 867, 8, 768, 76, 867, 8
    };
    int[] kthLargest = getLeastNumbers(ints, 2);
    System.out.println(kthLargest);
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[] {};
    }
    // 最后一个参数表示我们要找的是下标为k-1的数
    quickSearch(arr, 0, arr.length - 1, k - 1);
    return Arrays.copyOfRange(arr, 0, k);
  }

  private int[] quickSearch(int[] nums, int lo, int hi, int k) {
    int calculatedIndex = getPartition(nums, lo, hi);
    if (calculatedIndex == k) {
      return Arrays.copyOfRange(nums, 0, k);
    }
    return calculatedIndex > k
        ? quickSearch(nums, lo, calculatedIndex - 1, k)
        : quickSearch(nums, calculatedIndex + 1, hi, k);
  }

  public int getPartition(int[] nums, int start, int end) {
    int splitNumber = nums[start];
    while (start < end) {
      while (start < end && splitNumber <= nums[end]) {
        end--;
      }
      swap(nums, start, end);
      while (start < end && splitNumber >= nums[start]) {
        start++;
      }
      swap(nums, start, end);
    }
    return start;
  }

  public void swap(int[] nums, int left, int right) {
    int tmpVal = nums[left];
    nums[left] = nums[right];
    nums[right] = tmpVal;
  }
}
