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
    int idx=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        // return build(preorder,inorder,0,n-1);
        return build(preorder,0,n-1);
    }
    // public TreeNode build(int[] preorder, int[] inorder, int l, int r) {
    //     if(l > r) return null;
    //     int rootVal = preorder[idx++];
    //     int mid = map.get(rootVal);
    //     TreeNode root = new TreeNode(rootVal);
    //     root.left = build(preorder, inorder, l, mid - 1);
    //     root.right = build(preorder, inorder, mid + 1, r);
    //     return root;
    // }
    public TreeNode build(int[] preorder,int l, int r) {
        if(l > r) return null;
        int rootVal = preorder[idx++];
        int mid = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, l, mid - 1);
        root.right = build(preorder, mid + 1, r);
        return root;
    }
}