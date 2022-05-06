package com.roger.leetcodejava.jianzhi.solution_32_2;

import com.roger.leetcodejava.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 骆佳俊
 * @date: 2022/5/3 9:05 PM
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
    List<List<Integer>> lists = solution.levelOrder(treeNodeA);
    System.out.println(lists);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<Integer>> lists = new ArrayList<>();
    while (!queue.isEmpty()) {
      ArrayList<Integer> itemList = new ArrayList<>();
      int len = queue.size();
      while (len > 0) {
        TreeNode tmpNode = queue.remove();
        itemList.add(tmpNode.val);
        if (tmpNode.left != null) {
          queue.add(tmpNode.left);
        }
        if (tmpNode.right != null) {
          queue.add(tmpNode.right);
        }
        len--;
      }
      lists.add(itemList);
    }
    return lists;
  }
}
