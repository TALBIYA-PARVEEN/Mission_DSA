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
// class Solution {
//     public int minDepth(TreeNode root) {
        
//     }
// }
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        int min=Math.min(l,r);
        if(l==0)min=r;
        else if(r==0)min=l;
        // else min=Math.min(l,r);
        return min+1;
    }
}