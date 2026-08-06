class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;;i++){
            if(product(i)%t==0)return i;
        }
        
    }
    public int product(int n){
        int p=1;
        for(int i=n;i>0;i/=10){
            p*=i%10;
        }
        return p;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna