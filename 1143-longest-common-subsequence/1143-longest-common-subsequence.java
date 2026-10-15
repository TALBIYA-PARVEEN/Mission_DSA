// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int l=0;
//         int r=0;
//         int n1=text1.length();
//         int n2=text2.length();
//         int n=(n1>n2)?n1:n2;
//         int count=0;
//         for(int i=0;i<n;i++){
//             int c=0;
//             while(l<n1 && r<n2){
//                 if(text1.charAt(l)!=text2.charAt(r)){
//                     if(n1>n2){
//                         l++;
//                     }
//                     else r++;
//                 }
//                 else {
//                     c++;
//                     l++;
//                     r++;
//                 }
//             }
//             count=Math.max(count,c);
//         }
//         return count;
//     }
// }


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++){
        //     if(text1.charAt(i)==text2.charAt(0))dp[i][0]=1;
        // }
        // for(int j=0;j<n2;j++){
        //     if(text1.charAt(0)==text2.charAt(j))dp[0][j]=1;
        // }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)!=text2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else dp[i][j]=dp[i-1][j-1]+1;
            }
        }
        return dp[n1][n2];
    }
}

