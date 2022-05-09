package com.roger.leetcodejava.normal.数组中的第K个最大元素.全量快排;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/9 7:37 AM
 *     <p>运行结果
 *     <p>执行用时： 31 ms , 在所有 Java 提交中击败了 8.13% 的用户
 *     <p>内存消耗： 41.6 MB , 在所有 Java 提交中击败了 32.63% 的用户
 */
public class Solution {
  @Test
  public void test() {
    int[] ints = {3, 2, 1, 5, 6, 4};
    int kthLargest = findKthLargest(ints, 2);
    System.out.println(kthLargest);
  }

  public int findKthLargest(int[] nums, int k) {
    quickSort(nums, 0, nums.length - 1);
    return nums[k - 1];
  }

  public void quickSort(int[] nums, int start, int end) {
    if (start < end) {
      int partition = getPartition(nums, start, end);
      quickSort(nums, partition + 1, end);
      quickSort(nums, start, partition - 1);
    }
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
