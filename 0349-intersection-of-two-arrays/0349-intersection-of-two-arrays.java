class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st =new HashSet<>();
        int n=nums1.length;
        int idx=0;
        int[] ans=new int[Math.min(nums1.length, nums2.length)];
        for(int i=0;i<n;i++){
            st.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(st.contains(nums2[i])){
                ans[idx++]=nums2[i];
                st.remove(nums2[i]);
            }
        }
        return Arrays.copyOf(ans,idx);
    }
}