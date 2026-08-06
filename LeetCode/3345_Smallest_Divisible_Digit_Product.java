class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<n+10;i++){
            if(product(i)%t==0)return i;
        }
        return -1;
    }
    public int product(int n){
        int p=1;
        for(int i=n;i>0;i/=10){
            p*=i%10;
        }
        return p;
    }
}
