class Solution {
    public int[] finalPrices(int[] prices) {
        int fprice[] = new int [prices.length];
        for(int i = 0; i < prices.length-1;i++){
            boolean flag = false;
            for(int j = i+1; j < prices.length; j++){
                  if(prices[j] <= prices[i]){
                    fprice[i] = prices[i] - prices[j];
                    flag = true;
                    break;
                  }
            }
            if(!flag)
                fprice[i] = prices[i]; 
        }
        fprice[prices.length-1] = prices[prices.length-1]; 
        return fprice;
    }
}