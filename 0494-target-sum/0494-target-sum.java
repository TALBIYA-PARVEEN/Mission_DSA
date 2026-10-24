class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return dp(nums,target,0,0);

    }
    public int dp(int[] nums, int target,int temp,int start){
        if (start == nums.length) {
            return temp == target ? 1 : 0;
        }
        int cnt=0;
        cnt += dp(nums, target, temp + nums[start], start + 1);
        cnt += dp(nums, target, temp - nums[start], start + 1);
        return cnt;
    }
}
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n=nums.length;
//         int[][] dp=new int[n+1][target+1];
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=target;j++){
//                 if(nums[i-1]<=j){
//                     dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
//                 }
//                 else dp[i][j]=dp[i-1][j];
//             }
//         }
//         return dp[n][target];
//     }
// }



// class Solution {
//     public int countOfSubsetsInAGivenSum(int[] nums, int target) {
//         int[][] dp=new int[21][target+1];
//         int n=nums.length;
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=target;j++){
//                 if(nums[i-1]<=j){
//                     dp[i][j]=dp[i-1][j] +dp[i-1][j-nums[i-1]];
//                 }
//                 else {
//                     dp[i][j]=dp[i-1][j];
//                 }
//             }
//         }
//         return dp[n][target];
//     }
// }