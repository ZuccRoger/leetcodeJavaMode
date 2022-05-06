package com.roger.leetcodejava.jianzhi.solution_32_1;

import com.roger.leetcodejava.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 骆佳俊
 * @date: 2022/5/2 3:07 PM
 *     <p>考的是一个层序遍历。 1. 因为是二叉树,所以每层的第一个节点的下标是已知的. 这道题考的是一个 bfs 广度优先遍历 额外辅助需要一个队列 程序 = 数据结构 + 算法
 */
public class Solution {
  @Test
  public void test() {
    Solution solution = new Solution();
    TreeNode treeNodeA = new TreeNode(3);
    TreeNode treeNodeB = new TreeNode(9);
    TreeNode treeNodeC = new TreeNode(20);
    TreeNode treeNodeD = new TreeNode(15);
    TreeNode treeNodeE = new TreeNode(7);
    treeNodeA.left = treeNodeB;
    treeNodeA.right = treeNodeC;
    treeNodeB.left = null;
    treeNodeB.right = null;
    treeNodeC.left = treeNodeD;
    treeNodeC.right = treeNodeE;
    int[] ints = solution.levelOrder(treeNodeA);
    System.out.println(ints);
  }

  public int[] levelOrder(TreeNode root) {
    /** 防止异常case */
    if (root == null) {
      return new int[0];
    }
    /** bfs 需要一个额外变量 去存储元素 */
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> list = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      /** 记得这里需要用remove 而不是poll 因为 poll 会返回null 但是remove不会 */
      root = queue.remove();
      list.add(root.val);
      if (root.left != null) {
        queue.add(root.left);
      }
      if (root.right != null) {
        queue.add(root.right);
      }
    }
    /** 这里的list 转 int[]数组非常巧妙 */
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
