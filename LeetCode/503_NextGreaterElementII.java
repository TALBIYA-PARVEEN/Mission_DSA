class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int curr=nums[i%n];
            while(!stk.empty() && stk.peek()<=curr)stk.pop();
            if(i<n){
                arr[i]=stk.empty()?-1:stk.peek();
            }
            stk.push(curr);
        }
        return arr;
    }
}
