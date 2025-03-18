/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
function TreeNode(val, left, right) {
         this.val = (val===undefined ? 0 : val)
         this.left = (left===undefined ? null : left)
         this.right = (right===undefined ? null : right)
}


var calcDepthTree = function(node, parent, maxDepth){
    let leftDepth=0;
    let rightDepth=0;
    if(node.left!=null){
        leftDepth=calcDepthTree(node.left, parent, maxDepth);
    }
    if(node.left!=null){
        rightDepth=calcDepthTree(node.right, parent, maxDepth);
    }
    if(leftDepth>rightDepth){
        return leftDepth+1;
    }
    else if(leftDepth<rightDepth){
        return rightDepth+1;
    }
    else if(leftDepth==rightDepth&&leftDepth+1>maxDepth){
        parent==node;
        maxDepth=leftDepth+1;
        return leftDepth+1;
    }
}


/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var lcaDeepestLeaves = function(root) {
    
    let parent=root;
    let maxDepth=1;
    calcDepthTree(root, parent, maxDepth);
    return parent;
};

