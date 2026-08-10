class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max_diff=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                int element_idx=stk.peek();
                stk.pop();
                int nse=i;
                int pse=(stk.isEmpty())?-1:stk.peek();
                int width=nse-pse-1;
                max_diff=Math.max(max_diff,width*heights[element_idx]);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int element_idx=stk.peek();
            stk.pop();
            int pse=(stk.isEmpty())?-1:stk.peek();
            int nse=n;
            int width=nse-pse-1;
            max_diff=Math.max(max_diff,width*heights[element_idx]);
        }
        return max_diff;
    }
}