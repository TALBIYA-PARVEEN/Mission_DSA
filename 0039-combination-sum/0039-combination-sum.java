class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int start,int sum,int target,int[] candidates,List<Integer> temp,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target)return;
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(i,sum,target,candidates,temp,ans);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}