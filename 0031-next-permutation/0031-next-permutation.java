class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1])break;
        }
        if(i>=0){
            int j=n-1;
            while(j>i && nums[j]<=nums[i])j--;
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
        }
        reverse(i+1,n-1,nums);
    }
    public void reverse(int start,int end,int[] a){
        while(start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}