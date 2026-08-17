
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int n=nums1.length;
        int idx=0;
        int[] ans=new int[Math.min(nums1.length, nums2.length)];
        for(int i=0;i<n;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])!=0){
                ans[idx++]=nums2[i];
                map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
            }
        }
        return Arrays.copyOf(ans,idx);
    }
}