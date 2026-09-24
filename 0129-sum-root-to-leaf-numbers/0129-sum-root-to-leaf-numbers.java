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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int temp){
        if(root==null)return;
        temp=temp*10+root.val;
        if(root.left==null && root.right==null){
            sum+=temp;
            return;
        }
        dfs(root.left,temp);
        dfs(root.right,temp);
    }
}