class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        int buy=prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<buy)buy=prices[i];
            else max=Math.max(max,prices[i]-buy);
        }
        return max;
    }
}