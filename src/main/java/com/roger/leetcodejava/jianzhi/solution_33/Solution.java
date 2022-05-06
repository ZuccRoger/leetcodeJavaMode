package com.roger.leetcodejava.jianzhi.solution_33;

import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/4 9:46 AM
 *     <p>解题思路: 概念介绍: 二叉搜索树: 左子树上的节点的值 小于 根,右子树上的节点的值 大于 根。 如何判断是否跳出递归? left>right? left right end
 *     左子树 右子树 根
 */
public class Solution {
  @Test
  public void test() {
    boolean b = verifyPostorder(new int[] {1, 2, 5, 10, 6, 9, 4, 3});
    System.out.println(b);
  }

  public boolean verifyPostorder(int[] postorder) {
    return mainCore(postorder, 0, postorder.length - 1);
  }

  public boolean mainCore(int[] postOrder, int start, int end) {
    /** 跳出递归的条件 */
    if (start > end) {
      return true;
    }
    int count = start;
    int head = postOrder[end];
    // 找到第一个右子树的节点
    for (; count < postOrder.length; count++) {
      if (postOrder[count] >= head) {
        break;
      }
    }
    for (int i = count; i < end; i++) {
      if (postOrder[i] <= head) {
        return false;
      }
    }
    /** mark! 这里的end需要-1 */
    return mainCore(postOrder, start, count - 1) && mainCore(postOrder, count, end - 1);
  }
}
