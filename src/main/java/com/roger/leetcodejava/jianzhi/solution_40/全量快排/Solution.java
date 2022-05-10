package com.roger.leetcodejava.jianzhi.solution_40.全量快排;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: 骆佳俊
 * @date: 2022/5/10 7:19 AM
 */
public class Solution {
  @Test
  public void test() {
    int[] leastNumbers = getLeastNumbers(new int[] {3, 2, 1}, 2);
    System.out.println(leastNumbers);
  }

  public void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partition = getPartition(arr, start, end);
      quickSort(arr, start, partition - 1);
      quickSort(arr, partition + 1, end);
    }
  }

  public int getPartition(int[] arr, int start, int end) {
    int splitNumber = arr[start];
    while (start < end) {
      while (start < end && splitNumber <= arr[end]) {
        end--;
      }
      swap(arr, start, end);
      while (start < end && splitNumber >= arr[start]) {
        start++;
      }
      swap(arr, start, end);
    }
    return start;
  }

  public void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    quickSort(arr, 0, arr.length - 1);
    return Arrays.copyOfRange(arr, 0, k);
  }
}
