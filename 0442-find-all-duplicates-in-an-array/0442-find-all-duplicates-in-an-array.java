class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);
            if(nums[val-1]<0)ans.add(Math.abs(nums[i]));
            else nums[val-1]=-nums[val-1];
        }
        return ans;
    }
}