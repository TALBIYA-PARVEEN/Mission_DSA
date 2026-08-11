class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int sum=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && height[stk.peek()]<height[i]){
                int height_val=height[stk.peek()];
                stk.pop();
                int left=0;
                if(!stk.isEmpty())left=stk.peek();
                else break;
                int width=i-left-1;
                int bounded=Math.min(height[left],height[i])-height_val;
                sum+=width*bounded;
            }
            stk.push(i);
        }
        return sum;
    }
}