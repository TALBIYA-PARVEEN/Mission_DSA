class Solution {
    public int numSquares(int n) {
        int idx=(int)Math.sqrt(n);
        int[][] dp=new int[n+1][idx+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=n+1;
        }
        for(int j=0;j<=idx;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=idx;j++){
                dp[i][j]=dp[i][j-1];
                if (i >= j * j){
                    dp[i][j]=Math.min(dp[i][j-1],1+dp[i-j*j][j]);
                }
            }
        }
        return dp[n][idx];
    }
}

        
                // if (sum >= square) {
                //     dp[sum][j] = Math.min(
                //         dp[sum][j],
                //         1 + dp[sum - square][j]
                //     );
                // }

// class Solution {
//     int min=Integer.MAX_VALUE;
//     public int numSquares(int n) {
//         int idx=(int)Math.sqrt(n);
//         dp(n,idx,0,0);
//         return min;
//     }
//     public  void dp(int n,int idx,int temp,int cnt){
//         if(temp==n){
//             min=Math.min(min,cnt);
//             return;
//         }
//         if(temp>n)return ;
//         for(int i=1;i<=idx;i++){
//             temp+=i*i;
//             cnt++;
//             dp(n,idx,temp,cnt);
//             temp-=i*i;
//             cnt--;
//         }
//     }
// }
// class Solution {
//     public int numSquares(int n) {
//         int min=Integer.MAX_VALUE;
//         for(int i=1;i<n;i++){
//             int temp=1;
//             for(int j=1;j<n;j++){
//                 temp*=i*i;
//                 if(temp==n){
//                     cnt++;
//                     min=Math.min(cnt,min);
//                 }
//             }
//         }
//         return min;
//     }
// }