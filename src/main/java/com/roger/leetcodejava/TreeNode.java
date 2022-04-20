package com.roger.leetcodejava;

/**
 * @author: 骆佳俊
 * @date: 2022/4/20 8:03 AM
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
