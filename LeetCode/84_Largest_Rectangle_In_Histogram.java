class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n = heights.length;
        int[] pse = previousSmallerElement(heights);
        int[] nse = nextSmallerElement(heights);
        for(int i=0;i<n;i++){
            int width=nse[i]-pse[i]-1;
            int area=width*heights[i];
            max=Math.max(max,area);
        }
        return max;
    }
    public int[] previousSmallerElement(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        return pse;
    }
    public int[] nextSmallerElement(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }

        return nse;
    }
}
