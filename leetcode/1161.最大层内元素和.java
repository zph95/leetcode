/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
 *
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (65.61%)
 * Likes:    129
 * Dislikes: 0
 * Total Accepted:    43.7K
 * Total Submissions: 66.6K
 * Testcase Example:  '[1,7,0,7,-8,null,null]'
 *
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在 [1, 10^4]范围内
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    Map<Integer,Integer> levelSumMap=new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        return levelSumMap.entrySet().stream().max((x,y)->{
            if(x.getValue()>y.getValue()){
                return 1;
            }
            else if(x.getValue()<y.getValue()){
                return -1;
            }
            else{
                return 0;
            }
        }).get().getKey()+1;
    }

    private void dfs(TreeNode root, Integer level){
        if(root==null){
            return;
        }
        else{
            levelSumMap.put(level, levelSumMap.getOrDefault(level, 0)+root.val);
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }

    }
}
// @lc code=end

