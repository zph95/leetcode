/*
 * @lc app=leetcode.cn id=1339 lang=java
 *
 * [1339] 分裂二叉树的最大乘积
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long totalSum = 0; // 整棵树的总和
    private long maxProduct = 0; // 最大乘积
    private final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // 第一次遍历计算整棵树的总和
        totalSum = calculateSum(root);

        // 第二次遍历计算每个子树的和，并更新最大乘积
        calculateSubtreeSum(root);

        // 返回最大乘积，取模
        return (int) (maxProduct % MOD);
    }

    // 计算整棵树的总和
    private long calculateSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }

    // 计算每个子树的和，并更新最大乘积
    private long calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        // 当前子树的和
        long subtreeSum = node.val + calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);

        // 尝试分裂，计算乘积
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
// @lc code=end

