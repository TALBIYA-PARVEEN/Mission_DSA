class Solution {
    public int maximumValue(String[] strs) {
        int max=0;
        int length=0;
        for(int i=0;i<strs.length;i++){
            boolean flag=strs[i].matches(".*[a-zA-Z].*");
            if(flag){
                length=strs[i].length();
                max=Math.max(length,max);
            }
            else{
                length=Integer.parseInt(strs[i]);
                max=Math.max(length,max);
            }
        }
        return max;
    }
}