class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long sum=0;
        int mod=1000000007;
        int pse=-1;
        int nse=n;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!stk.isEmpty() && (i>=n || arr[stk.peek()]>arr[i]) ){
                int mid=stk.pop();
                if(stk.isEmpty())pse=-1;
                else pse=stk.peek();
                if(i==n)nse=n;
                else nse=i;
                long contri=((long)arr[mid]*(mid-pse)*(nse-mid))%mod;
                sum=(sum+contri)%mod;
            }
            if(i<n)stk.push(i);
        }
        return (int)sum;
    }
}