package com.roger.leetcodejava.normal.数组中的第K个最大元素.局部快排;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: 骆佳俊
 * @date: 2022/5/9 9:21 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] ints = {3, 2, 1, 5, 6, 4};
    int kthLargest = findKthLargest(ints, 2);
    System.out.println(kthLargest);
  }

  public int findKthLargest(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return 0;
    }
    // 最后一个参数表示我们要找的是下标为k-1的数
    int[] ints = quickSearch(arr, 0, arr.length - 1, k - 1);
    return ints[k - 1];
  }

  private int[] quickSearch(int[] nums, int lo, int hi, int k) {
    // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
    int j = getPartition(nums, lo, hi);
    if (j == k) {
      return Arrays.copyOf(nums, j + 1);
    }
    // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
    return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
  }

  public int getPartition(int[] nums, int start, int end) {
    int splitNumber = nums[start];
    while (start < end) {
      while (start < end && splitNumber >= nums[end]) {
        end--;
      }
      swap(nums, start, end);
      while (start < end && splitNumber <= nums[start]) {
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
