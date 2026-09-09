class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        long sum=0;
        Stack<Integer> stk=new Stack<>();
        int i=n-1;
        while(i>=0){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])stk.pop();
            if(stk.isEmpty())nse[i]=n;
            else nse[i]=stk.peek();
            stk.push(i);
            i--;
        }
        stk.clear();
        i=0;
        while(i<n){
            while(!stk.isEmpty() && arr[stk.peek()]>arr[i])stk.pop();
            if(stk.isEmpty())pse[i]=-1;
            else pse[i]=stk.peek();
            stk.push(i);
            i++;
        }
        for(int j=0;j<n;j++){
            long contribution=((long)arr[j]*(j-pse[j])*(nse[j]-j))%1000000007;
            sum=(sum+contribution)%1000000007;
        }
        return (int)sum;
    }
}
