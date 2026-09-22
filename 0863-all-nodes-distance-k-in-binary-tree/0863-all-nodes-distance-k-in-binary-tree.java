/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    List<Integer> ans=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root,null);
        bfs(target,k,new HashSet<>());
        return ans;
    }
    public void buildParent(TreeNode root,TreeNode parent){
        if(root==null)return;
        map.put(root,parent);
        buildParent(root.left,root);
        buildParent(root.right,root);
    }
    public void bfs(TreeNode target,int k,HashSet<TreeNode> st){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        st.add(target);
        while(!q.isEmpty()){
            if(k==0){
                while(!q.isEmpty()){
                    TreeNode temp=q.poll();
                    ans.add(temp.val);
                }   
                return;         
            }
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                TreeNode parent=map.get(temp);
                if(parent!=null && !st.contains(parent)){
                    q.offer(parent);
                    st.add(parent);
                }
                if(temp.left!=null && !st.contains(temp.left)){
                    q.offer(temp.left);
                    st.add(temp.left);
                }
                if(temp.right!=null && !st.contains(temp.right)){
                    q.offer(temp.right);
                    st.add(temp.right);
                }
            }
            k--;
        }
    }
}