class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] prefix=new int[n];
        prefix[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            prefix[i]=Math.max(prefix[i+1],prices[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(prefix[i]-prices[i],max);
        }
        return max;
    }
}