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
    int max_cnt=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        dfs(root,root.val);
        return max_cnt;
    }
    public int dfs(TreeNode root,int temp){
        if(root==null)return 0;
        int l=dfs(root.left,temp);
        int r=dfs(root.right,temp);
        if(root.left!=null && root.left.val!=root.val)l=0;
        if(root.right!=null &&  root.right.val!=root.val)r=0;
        max_cnt=Math.max(max_cnt,l+r);
        return Math.max(l,r)+1;
    }
}