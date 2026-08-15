class Solution {
    public int countGoodNumbers(long n) {
        long n1=n/2;
        long n2=n-n1;
        long mod=1000000007;
        long first=pow(5,n2);
        long second=pow(4,n1);
        long ans=(first*second)%mod;
        return (int)ans;
    }
    public long pow(long x,long n){
        long mod=1000000007;
        if(n==0)return 1;
        if(n==1)return x;
        long ret=x%mod;
        if(n%2==0){
            return pow((ret*ret)%mod,n/2);
        }
        else {
            long half=pow(ret,n/2)%mod;
            long rethalf=(half*half)%mod;
            return (ret*rethalf)%mod;
        }
    }
}