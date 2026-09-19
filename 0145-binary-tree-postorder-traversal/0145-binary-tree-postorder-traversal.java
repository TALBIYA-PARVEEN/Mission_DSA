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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } 
            else {
                TreeNode top = stack.peek();
                if (top.right != null && top.right != prev) {
                    curr = top.right;
                } 
                else {
                    ans.add(top.val);
                    prev = stack.pop();
                }
            }
        }
        return ans;
    }
}