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
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         // Base case: if both trees are null, they are identical
//         if (p == null && q == null) {
//             return true;
//         }
//         // If only one tree is null or the values are different, they are not identical
//         if (p == null || q == null || p.val != q.val) {
//             return false;
//         }
//         // Recursively check if the left and right subtrees are identical
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if(p==null)return false;
        if(q==null)return false;
        if(p.val!=q.val)return false;
        boolean l=dfs(p.left,q.left);
        boolean r=dfs(p.right,q.right);
        if( l && r)return true;
        return false;
    }
}