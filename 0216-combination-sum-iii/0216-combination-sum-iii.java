class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(1,k,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int start,int k,int sum,int target,List<Integer> temp,List<List<Integer>> ans){
        if(temp.size()==k && sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target || start>9)return;
        for(int i=start;i<=9;i++){
            temp.add(i);
            sum+=i;
            backtrack(i+1,k,sum,target,temp,ans);
            sum-=i;
            temp.remove(temp.size()-1);
        }
    }
}