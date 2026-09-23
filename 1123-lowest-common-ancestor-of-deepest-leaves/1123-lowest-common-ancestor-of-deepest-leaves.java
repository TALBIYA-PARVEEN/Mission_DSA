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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode result = null;
        int height=dfs(root,null);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            if(height==1){
                result = q.poll();
                while (!q.isEmpty()) {
                    result = lca(result, q.poll());
                }
                return result;
            }
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            height--;
        }
        return null;
    }
    public int dfs(TreeNode root,TreeNode parent){
        if(root==null)return 0;
        map.put(root,parent);
        int left=dfs(root.left,root);
        int right=dfs(root.right,root);
        return Math.max(left,right)+1;
    }
    public TreeNode lca(TreeNode p, TreeNode q) {
        HashSet<TreeNode> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (q != null) {
            if (set.contains(q)) return q;
            q = map.get(q);
        }

        return null;
    }
}