package com.roger.leetcodejava.jianzhi.solution_32_3;

import com.roger.leetcodejava.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 骆佳俊
 * @date: 2022/5/4 8:51 AM
 */
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    ArrayList<List<Integer>> resultList = new ArrayList<>();
    /** 空树 */
    if (root == null) {
      return resultList;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      ArrayList<Integer> layerList = new ArrayList<>();
      /** 个人认为这个分层是比较难的。不知道如何处理 */
      int size = queue.size();
      while (size > 0) {
        TreeNode firstNode = queue.poll();
        layerList.add(firstNode.val);
        if (firstNode.left != null) {
          queue.add(firstNode.left);
        }
        if (firstNode.right != null) {
          queue.add(firstNode.right);
        }
        size--;
      }
      resultList.add(layerList);
    }
    for (int i = 0; i < resultList.size(); i++) {
      if (i % 2 == 1) {
        Collections.reverse(resultList.get(i));
      }
    }
    return resultList;
  }

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
    List<List<Integer>> lists = solution.levelOrder(treeNodeA);
    System.out.println(lists);
  }
}
