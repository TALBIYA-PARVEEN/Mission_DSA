class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        int j=n-1;
        if(i>=0){
            while(j>i && nums[i]>=nums[j]){
                j--;
            }
        }
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        reverse(nums,i+1,n-1);
        // return nums;
    }
    public static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}