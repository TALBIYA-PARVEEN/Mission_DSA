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

    ArrayList<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;

        dfs(root);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode curr = list.get(i);
            TreeNode next = list.get(i + 1);

            curr.left = null;
            curr.right = next;
        }
    }

    public void dfs(TreeNode temp) {
        if (temp == null) return;

        list.add(temp);

        dfs(temp.left);
        dfs(temp.right);
    }
}