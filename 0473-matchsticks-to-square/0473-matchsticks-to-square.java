class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        int sum=0;
        for(int i:matchsticks){
            sum+=i;
        }
        if(sum%4!=0)return false;
        int target=sum/4;
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }
        return dp(matchsticks,0,0,0,0,0,target);
    }
    private boolean dp(int[] matchsticks,int i,int s1,int s2,int s3,int s4,int target){
        if(i==matchsticks.length)return (s1==s2) && (s2==s3) && (s3==s4);
        else{
            if(s1+matchsticks[i]<=target && dp(matchsticks,i+1,s1+matchsticks[i],s2,s3,s4,target))return true;
            if(s2+matchsticks[i]<=target && dp(matchsticks,i+1,s1,s2+matchsticks[i],s3,s4,target))return true;
            if(s3+matchsticks[i]<=target && dp(matchsticks,i+1,s1,s2,s3+matchsticks[i],s4,target))return true;
            if(s4+matchsticks[i]<=target && dp(matchsticks,i+1,s1,s2,s3,s4+matchsticks[i],target))return true;
            return false;
        }
    }
}