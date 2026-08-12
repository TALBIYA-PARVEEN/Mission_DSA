class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.get(nums[i]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }

            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}