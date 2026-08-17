class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        int idx=0;
        int[] ans=new int[Math.min(n1,n2)];
        while(i<n1 && j<n2){
            if(nums1[i]==nums2[j]){
                ans[idx++]=nums1[i];
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j])j++;
            else if(nums1[i]<nums2[j])i++;
        }
        return Arrays.copyOf(ans,idx);
    }
}