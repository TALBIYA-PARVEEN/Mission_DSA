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
    public int pathSum(TreeNode root, int sum) {
        if (root==null)return 0;
        return dfs(root,sum,0)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int dfs(TreeNode root, int sum,int temp){
        if(root==null)return 0;
        temp+=root.val;
        int count = 0;
        if(sum==temp){
            count++;
        }
        count+=dfs(root.left,sum,temp);
        count+=dfs(root.right,sum,temp);
        temp-=root.val;
        return count;
    }
}
