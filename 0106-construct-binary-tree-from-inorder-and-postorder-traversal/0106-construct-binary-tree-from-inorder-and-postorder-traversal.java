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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=postorder.length;
        idx=n-1;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return convert(postorder,map,0,n-1);
    }
    public TreeNode convert(int[] postorder,HashMap<Integer,Integer> map,int l,int r){
        if(l>r)return null; 
        int temp=postorder[idx]; 
        idx--;  
        TreeNode root=new TreeNode(temp);
        int idx_m=map.get(temp);
         
        root.right=convert(postorder,map,idx_m+1,r);
         root.left=convert(postorder,map,l,idx_m-1); 
        return root;
    }
}