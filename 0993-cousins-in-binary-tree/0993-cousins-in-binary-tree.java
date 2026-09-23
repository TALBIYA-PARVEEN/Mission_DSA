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
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        buildParent(root,null);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            TreeNode a=null;
            TreeNode b=null;
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                if(temp.val==x)a=temp;
                if(temp.val==y)b=temp;
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            if (a != null && b != null) {
                return map.get(a) != map.get(b);
            }
        }
        return false;
    }
    public void buildParent(TreeNode root,TreeNode parent){
        if(root==null)return;
        map.put(root,parent);
        buildParent(root.left,root);
        buildParent(root.right,root);
    }
}