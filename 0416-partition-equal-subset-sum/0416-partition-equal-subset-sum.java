class Solution {
    boolean[][] dp=new boolean[201][10001];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        return bucket(nums,target,nums.length-1);
    }
    public boolean bucket(int[] nums,int target,int n){
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]]  || dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][target];
    }
}