class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(1,k,new ArrayList<>(),ans,n);
        return ans;
    }
    public void recursion(int idx,int k,ArrayList<Integer> temp,List<List<Integer>> ans,int n){
        if(k==temp.size()){
            ans.add(new ArrayList<Integer>(temp));
        }
        for(int i=idx;i<=n;i++){
            temp.add(i);
            recursion(i+1,k,temp,ans,n);
            temp.remove(temp.size()-1);
        }
    }
}