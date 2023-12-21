/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (70.05%)
 * Likes:    2541
 * Dislikes: 0
 * Total Accepted:    621.9K
 * Total Submissions: 887.7K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [2, 10^5] 内。
 * -10^9 
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode,TreeNode> parentMap=new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        List<TreeNode> pRet=findTreeNode(p);
        List<TreeNode> qRet=findTreeNode( q);
        int minLength=Math.min(pRet.size(), qRet.size());
        TreeNode ret=null;
        for(int i=0;i<minLength;i++){
            if(pRet.get(i).val==qRet.get(i).val){
                ret=pRet.get(i);
            }
            else{
                return ret;
            }
        }
        return ret;
        
    }

    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parentMap.put(root.left, root);
            dfs(root.left);
        }
        if(root.right!=null){
            parentMap.put(root.right, root);
            dfs(root.right);
        }
    }
    public List<TreeNode> findTreeNode(TreeNode node){
        List<TreeNode> ret=new ArrayList<>();
        ret.add(node);
        TreeNode tmp=node;
        while(parentMap.get(tmp)!=null){
            tmp=parentMap.get(tmp);
            ret.add(tmp);
        }
        Collections.reverse(ret);
        return ret;
    }
    

    public List<TreeNode> findTreeNode(TreeNode root, List<TreeNode> list,TreeNode node){
        List<TreeNode> tmp=list.stream().collect(Collectors.toList());
        if(root==null){
            return null;
        }

        tmp.add(root);
        if(root.val==node.val){
            return tmp;
        }

        List<TreeNode> leftRet = findTreeNode(root.left, tmp, node);
        List<TreeNode> rightRet = findTreeNode(root.right, tmp, node);
        if(leftRet==null){
            return rightRet;
        }
        else{
            return leftRet;
        }
    }
}
// @lc code=end

