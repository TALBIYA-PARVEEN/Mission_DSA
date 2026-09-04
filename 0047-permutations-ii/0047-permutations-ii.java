class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flag=new boolean[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(new ArrayList<>(),ans,nums,flag);
        return ans;
    }
    public void backtrack(List<Integer> temp,List<List<Integer>> ans,int[] nums,boolean[] flag){
        if(temp.size()==nums.length){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !flag[i-1])continue;
            temp.add(nums[i]);
            flag[i]=true;
            backtrack(temp,ans,nums,flag);
            flag[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}