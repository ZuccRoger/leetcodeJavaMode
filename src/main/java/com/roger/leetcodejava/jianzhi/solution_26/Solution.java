package com.roger.leetcodejava.jianzhi.solution_26;

import com.roger.leetcodejava.TreeNode;
import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/5/8 10:53 AM
 */
public class Solution {
  /** 约定空树不是任意一个树的子结构 */
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A == null || B == null) {
      return false;
    }
    return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }

  /** 以下代码太精髓了! */
  public boolean dfs(TreeNode A, TreeNode B) {
    if (B == null) {
      return true;
    }
    if (A == null) {
      return false;
    }
    /**
     * 注意！:
     *
     * <p>1. 这里是&& 而不是 ||
     *
     * <p>2. 然后是左右子树分别去进行比对。
     */
    return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
  }

  @Test
  public void test() {
    TreeNode treeNodeA = new TreeNode(3);
    TreeNode treeNodeB = new TreeNode(4);
    TreeNode treeNodeC = new TreeNode(5);
    TreeNode treeNodeD = new TreeNode(1);
    TreeNode treeNodeE = new TreeNode(2);
    treeNodeA.left = treeNodeB;
    treeNodeA.right = treeNodeC;
    treeNodeB.left = treeNodeD;
    treeNodeB.right = treeNodeE;

    TreeNode treeNodeF = new TreeNode(4);
    TreeNode treeNodeG = new TreeNode(1);
    treeNodeF.left = treeNodeG;

    System.out.println(isSubStructure(treeNodeA, treeNodeF));
  }
}
