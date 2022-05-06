package com.roger.leetcodejava.jianzhi.solution_30.byLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 骆佳俊
 * @date: 2022/5/5 7:28 AM
 *     <p>为什么使用Deque 而不是直接使用Stack
 *     <p>首先因为class Stack<E> extends Vector<E> 继承自 Vector
 *     <p>Stack作为java语言的栈，是被诟病的地方，作为栈数据结构，却继承了vector，对外暴露了get(index)这样的方法，不是一种合理的实现方式，所以后来java开发提倡使用ArrayDeque
 *     <p>另外题目中有要求说调用 min、push 及 pop 的时间复杂度都是O(1) 所以有一个minStack 存放最小值
 *     <p>执行用时： 13 ms , 在所有 Java 提交中击败了 63.74% 的用户 内存消耗： 43.5 MB , 在所有 Java 提交中击败了 34.30% 的用户
 */
class MinStack {
  /** initialize your data structure here. */
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

  private Deque<Integer> xStack;

  private Deque<Integer> minStack;

  public MinStack() {
    xStack = new LinkedList<>();
    minStack = new LinkedList<>();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    /**
     * 这里 Math.min(x,minStack.peek()) 是非常巧妙的 因为如果xStack pop的话 minStack也会同步pop
     * 并且保证了minStack的第一个元素是最小的.
     */
    xStack.push(x);
    minStack.push(Math.min(x, minStack.peek()));
  }

  public void pop() {
    xStack.pop();
    minStack.pop();
  }

  public int top() {
    return xStack.peek();
  }

  public int min() {
    return minStack.peek();
  }
}
