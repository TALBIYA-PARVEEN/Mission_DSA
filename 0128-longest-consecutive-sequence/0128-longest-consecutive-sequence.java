class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        if(nums.length==0)return 0;
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            // if((i-1>=0&&nums[i]==nums[i-1])|| st.contains(nums[i] - 1))continue;
            if((i-1>=0&&nums[i]==nums[i-1]))continue;
            int cnt=1;
            int first=nums[i];
            while(st.contains(first+1)){
                cnt++;
                first=first+1;
                i++;
            }
            max=Math.max(cnt,max);
        }
        return max;
    }
}