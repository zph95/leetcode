/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 *
 * https://leetcode.cn/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (52.31%)
 * Likes:    1285
 * Dislikes: 0
 * Total Accepted:    238.1K
 * Total Submissions: 455.2K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key
 * 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 
 * 一般来说，删除节点可分为两个步骤：
 * 
 * 
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: root = [], key = 0
 * 输出: []
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 节点数的范围 [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10^5 <= key <= 10^5
 * 
 * 
 * 
 * 
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * 
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
    TreeNode parent=null;
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node =  findNode(root, null, key);
        if(node==null){
            return root;
        }
        else if(parent==null){
            return updateTree(node.left, node.right);
        }
        else{
            delete(node);
            updateTree(node.left, node.right);
            return root;
        }
    }

    public void delete(TreeNode node){
        if(parent.left==node){
            if(node.right==null){
                parent.left=node.left;
            }
            else{
                parent.left=node.right;
            }
        }
        if(parent.right==node){
            if(node.right==null){
                parent.right=node.left;
            }
            else{
                parent.right=node.right;
            }
        }
    }
    public TreeNode updateTree(TreeNode left, TreeNode right){
            if(right==null){
                return left;
            }
            else if(left==null){
                return right;
            }
            TreeNode tmp=right;
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            tmp.left=left;
            return right;
    }
    
    public TreeNode findNode(TreeNode root, TreeNode p, int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            parent = p;
            return root;
        }
        if(root.val>key){
            return findNode(root.left, root, key);
        }
        if(root.val<key){
            return findNode(root.right, root, key);
        }
        return null;
    }
}
// @lc code=end

