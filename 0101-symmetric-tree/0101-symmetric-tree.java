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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Deque<TreeNode> q=new LinkedList<>();
        return bfs(root,q);
    }
    public boolean bfs(TreeNode root,Deque<TreeNode> q){
        q.addFirst(root.left);
        q.addFirst(root.right);
        while(!q.isEmpty()){
            TreeNode left=q.pollFirst();
            TreeNode right=q.pollLast();
            if(left==null && right ==null)continue;
            if(left==null || right ==null)return false;
            if(left.val != right.val)return false;
            q.addFirst(left.left);
            q.addFirst(left.right);
            q.addLast(right.right);
            q.addLast(right.left);
        }
        return true;
    }
}