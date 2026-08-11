class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] p = pge(height, n);
        int[] ne = nge(height, n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(p[i], ne[i]);
            sum += min - height[i];
        }
        return sum;
    }
    public static int[] pge(int[] height, int n) {
        int[] ans = new int[n];
        ans[0] = height[0];
        for (int i = 1; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], height[i]);
        }
        return ans;
    }
    public static int[] nge(int[] height, int n) {
        int[] ans = new int[n];
        ans[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], height[i]);
        }
        return ans;
    }
}