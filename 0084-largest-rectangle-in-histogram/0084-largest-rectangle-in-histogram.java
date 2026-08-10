class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max=0;
        int[] nse=next_smaller(heights,n);
        int[] pse=previous_smaller(heights,n);
        for(int i=0;i<n;i++){
            int width=nse[i]-pse[i]-1;
            max=Math.max(max,width*heights[i]);
        }
        return max;
    }
    public int[] next_smaller(int[] heights,int n){
        Stack<Integer> stk=new Stack<>();
        int[] ans=new int[n];
        int idx=n-1;
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i])stk.pop();
            if(stk.isEmpty())ans[idx--]=n;
            else ans[idx--]=stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] previous_smaller(int[] heights,int n){
        Stack<Integer> stk=new Stack<>();
        int[] ans=new int[n];
        int idx=0;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i])stk.pop();
            if(stk.isEmpty())ans[idx++]=-1;
            else ans[idx++]=stk.peek();
            stk.push(i);
        }
        return ans;
    }
}