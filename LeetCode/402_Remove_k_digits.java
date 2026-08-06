class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk=new Stack<>();
        char[] c=num.toCharArray();
        int n=num.length();
        if(k==n)return "0";
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && k>0 && stk.peek()>c[i]){
                stk.pop();
                k--;
            }
            stk.push(c[i]);
        }
        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();
        int nonZeroIdx = 0;
        while (nonZeroIdx < sb.length() && sb.charAt(nonZeroIdx) == '0') {
            nonZeroIdx++;
        }
        String result = sb.substring(nonZeroIdx);
        return result.isEmpty() ? "0" : result;
    }
}
