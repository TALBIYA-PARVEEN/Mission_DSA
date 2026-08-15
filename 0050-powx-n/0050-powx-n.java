class Solution {
    public double myPow(double x, int n) {
        double power=1;
        long no = n;
        if (no < 0) no = -no;
        while(no>0){
            // if(no%2!=0)power*=x;
            // x*=x;
            // no/=2;
            if(no%2!=0){
                power*=x;
                no-=1;
            }
            else{
                x*=x;
                no/=2;            

            }
        }
        return (n>0)?power:1/power;
    }
}