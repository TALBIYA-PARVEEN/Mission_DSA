class Solution {
    public boolean backtrack(int target,int index,int[] nums,int[] bucket){
        if(index<0)return true;
        if(nums[index]>target)return false;
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]+nums[index]<=target){
                bucket[i]+=nums[index];
                if(backtrack(target,index-1,nums,bucket))return true;
                bucket[i]-=nums[index];
                if(bucket[i] == 0)break;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int target=sum/k;
        if(sum%k!=0)return false;
        int[] bucket=new int[k];
        Arrays.sort(nums);
        return backtrack(target,nums.length-1,nums,bucket);
    }
}