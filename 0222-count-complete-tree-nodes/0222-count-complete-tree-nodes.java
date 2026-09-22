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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        TreeNode curr=root;
        int cnt_left=0;
        while(curr!=null){
            cnt_left++;
            curr=curr.left;
        }
        curr=root;
        int cnt_right=0;
        while(curr!=null){
            cnt_right++;
            curr=curr.right;
        }
        if(cnt_left==cnt_right)return (int)Math.pow(2,cnt_left)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
}