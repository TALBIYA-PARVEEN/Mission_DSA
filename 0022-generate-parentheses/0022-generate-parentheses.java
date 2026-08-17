class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        backtrack(0,0,n,sb,ans);
        return ans;
    }
    public void backtrack(int open,int close,int  n,StringBuilder temp,List<String> ans){
        if(open == n && close == n){
            ans.add(temp.toString());
            return;
        }

        if(open < n){
            temp.append('(');
            backtrack(open + 1, close, n, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(close < open){
            temp.append(')');
            backtrack(open, close + 1, n, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}