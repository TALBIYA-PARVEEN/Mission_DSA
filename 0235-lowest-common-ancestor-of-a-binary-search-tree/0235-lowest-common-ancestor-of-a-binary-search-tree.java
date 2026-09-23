/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//     }
// }
class Solution {
    TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return lca;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return false;
        boolean left=dfs(root.left,p,q);
        boolean right=dfs(root.right,p,q);
        if(root.left!=null && (root.left==p ||root.left==q))left=true;
        if(root.right!=null && (root.right==p || root.right==q))right=true;
        if(root==p || root==q){
            if(left)right=true;
            else left=true;
        }
        if(left && right){
            lca=root;
            return true;
        }
        return left || right;
    }
}