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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,sum,0,new ArrayList<>(),ans);
        return ans;
    }
    public void dfs(TreeNode root, int sum,int temp,ArrayList<Integer> lst,List<List<Integer>> ans ){
        if(root==null)return;
        lst.add(root.val);
        temp+=root.val;
        if(root.left==null && root.right==null && temp==sum){
            ans.add(new ArrayList<>(lst));
            lst.remove(lst.size() - 1);
            temp-=root.val;
            return;
        }
        dfs(root.left,sum,temp,lst,ans);
        dfs(root.right,sum,temp,lst,ans);
        lst.remove(lst.size() - 1);
        temp-=root.val;
    }
}