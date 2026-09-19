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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr=root;
        while(!stk.isEmpty() || curr!=null){
            if(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=stk.pop();
                ans.add(temp.val);
                curr=temp.right;
                // ans.add(stk.peek());
                // stk.pop();
            }
        }
        return ans;
    }
}