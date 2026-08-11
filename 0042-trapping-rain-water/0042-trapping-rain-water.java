class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int lm=Integer.MIN_VALUE;
        int rm=Integer.MIN_VALUE;
        int total=0;
        while(l<=r){
            if(height[l]<=height[r]){
                if(lm<=height[l])lm=height[l];
                else total+=lm-height[l];
                l++;
            }
            else{
                if(rm<=height[r])rm=height[r];
                else total+=rm-height[r];
                r--;
            }
        }
        return total;
    }
}