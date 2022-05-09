package com.roger.sort.快速排序;

/**
 * @author: 骆佳俊
 * @date: 2022/5/9 7:48 AM
 */
public class QuickSort {
  public static void main(String[] args) {
    int array[] = {5, 1, 4, 7, 9, 14, 3, 7, 5, 9, 2, 6, 8, 10};
    System.out.println("排序前序列为：");
    printArray(array);
    quickSort(array, 0, array.length - 1);
    System.out.println("排序后序列为：");
    printArray(array);
  }

  // 快速排序算法
  public static void quickSort(int array[], int start, int end) {
    if (start < end) {
      int partition = partition(array, start, end);
      /**
       * 注意： 这要+1 和 -1
       *
       * <p>因为我们的初始化splitNumber 的值是 array[start] 所以这个start特别关键.
       *
       * <p>如果我们每次start一样的话，就无法就行 区分 左右。 对 partition;
       */
      quickSort(array, partition + 1, end);
      quickSort(array, start, partition - 1);
    }
  }

  /** 分区操作 */
  public static int partition(int array[], int start, int end) {
    int splitNumber = array[start];
    while (start < end) {
      /** 注意这里是<= 否则会造成死循环 */
      while (start < end && splitNumber <= array[end]) {
        end--;
      }
      swap(array, start, end);
      /** 注意这里是>= */
      while (start < end && splitNumber >= array[start]) {
        start++;
      }
      swap(array, start, end);
    }
    return start;
  }

  // 交换序列中元素
  public static void swap(int array[], int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  // 打印序列中元素
  public static void printArray(int array[]) {
    int length = array.length;
    for (int i = 0; i < length; i++) {
      if (i != length - 1) {
        System.out.print(array[i] + " ");
      } else {
        System.out.println(array[i]);
      }
    }
  }
}
