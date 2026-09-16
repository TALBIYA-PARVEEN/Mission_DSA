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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Deque<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.offerFirst(root);
        int flag=1;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> tempo=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(flag==1){
                    TreeNode temp=q.pollLast();
                    tempo.add(0, temp.val);
                    if(temp.right!=null)q.offerFirst(temp.right);
                    if(temp.left!=null)q.offerFirst(temp.left);
                }
                else{
                    TreeNode temp=q.pollFirst();
                    tempo.add(0, temp.val);
                    if(temp.left!=null)q.offerLast(temp.left);
                    if(temp.right!=null)q.offerLast(temp.right);
                }
            }
            flag=-flag;
            ans.add(tempo);
        }
        return ans;
    }
}