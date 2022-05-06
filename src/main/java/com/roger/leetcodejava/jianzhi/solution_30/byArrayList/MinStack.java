package com.roger.leetcodejava.jianzhi.solution_30.byArrayList;

import java.util.ArrayList;

/**
 * @author: 骆佳俊
 * @date: 2022/5/5 7:10 AM
 *     <p>第一版代码
 *     <p>执行结果： 通过 显示详情 添加备注
 *     <p>执行用时： 110 ms , 在所有 Java 提交中击败了 5.66% 的用户 内存消耗： 43.3 MB , 在所有 Java 提交中击败了 56.68% 的用户
 *     通过测试用例： 19 / 19
 */
class MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.min());
  }

  private ArrayList<Integer> arrayList;
  /** initialize your data structure here. */
  public MinStack() {
    arrayList = new ArrayList<>();
  }

  public void push(int x) {
    arrayList.add(x);
  }

  public void pop() {
    arrayList.remove(arrayList.size() - 1);
  }

  public int top() {
    Integer integer = arrayList.get(arrayList.size() - 1);
    return integer.intValue();
  }

  public int min() {
    int minValue = arrayList.get(0);
    for (int i = 0; i < arrayList.size(); i++) {
      if (minValue > arrayList.get(i)) {
        minValue = arrayList.get(i);
      }
    }
    return minValue;
  }
}
