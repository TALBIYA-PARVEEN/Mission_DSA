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
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root,sum,0);
    }
    public boolean dfs(TreeNode root, int sum,int temp){
        if(root==null)return false ;
        temp+=root.val;
        if(root.left==null && root.right==null && temp==sum)return true;
        boolean l=dfs(root.left,sum,temp);
        boolean r=dfs(root.right,sum,temp);
        return l || r;
    }
}