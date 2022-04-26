package com.roger.leetcodejava.jianzhi.solution_07;

import com.roger.leetcodejava.TreeNode;
import org.junit.Test;

/**
 * @author: 骆佳俊
 * @date: 2022/4/24 7:39 PM 前序是 根左右 中序是 左根右
 */
public class Solution_07 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  /**
   * @param preorder 前序遍历的数组
   * @param preLeft 前序的左指针
   * @param preRight 前序的右指针
   * @param inorder 中序遍历的数组
   * @param inLeft 中序的左指针
   * @param inRight 中序的右指针
   * @return
   */
  public TreeNode helper(
      int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }
    int rootIndex = preLeft;
    int rootVal = preorder[rootIndex];

    for (int i = 0; i < inorder.length; i++) {
      if (rootVal == inorder[i]) {
        rootIndex = i;
        break;
      }
    }
    TreeNode treeNode = new TreeNode(rootVal);
    /** 错了2个地方 首先是一个没有给这个TreeNode 的 left 或者 right赋值 指针范围错误 */
    /** 先遍历左的 */
    treeNode.left =
        helper(preorder, preLeft + 1, preLeft + rootIndex - inLeft, inorder, inLeft, rootIndex - 1);
    /** 遍历右边 */
    treeNode.right =
        helper(
            preorder, preLeft + rootIndex - inLeft + 1, preRight, inorder, rootIndex + 1, inRight);
    return treeNode;
  }

  @Test
  public void test() {
    TreeNode treeNode = buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    System.out.println(treeNode);
  }
}
