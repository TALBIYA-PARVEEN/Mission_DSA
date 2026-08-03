class Solution {
    public int nextGreaterElement(int n) {
        String temp = Integer.toString(n);
        char[] c=temp.toCharArray();
        int index=-1;
        for(int i=c.length-2;i>=0;i--){
            if(c[i]<c[i+1]){
                index=i;
                break;
            }
        }
        if (index == -1) return -1;
        for(int j=c.length-1;j>index;j--){
            if(c[j]>c[index]){
                char t=c[j];
                c[j]=c[index];
                c[index]=t;
                break;
            }
        }
        int start = index+1;
        int end = c.length-1;

        while (start < end) {
            char te = c[start];
            c[start] = c[end];
            c[end] = te;
            
            start++;
            end--;
        }
        long val = Long.parseLong(new String(c));
        return val > Integer.MAX_VALUE ? -1 : (int) val;

    }
}
// done
