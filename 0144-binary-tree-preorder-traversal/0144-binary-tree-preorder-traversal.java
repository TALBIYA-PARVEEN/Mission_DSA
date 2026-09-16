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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();;
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node=stk.pop();
            ans.add(node.val);
            if(node.right!=null)stk.add(node.right);
            if(node.left!=null)stk.add(node.left);
        }
        return ans;
    }
}