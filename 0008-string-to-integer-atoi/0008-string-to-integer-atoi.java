class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0)return 0;
        char[] ch=s.toCharArray();
        int n=ch.length;
        int mag=1;
        int i=0;
        while(i<n && ch[i]==' ')i++;
        if (i == n) return 0;
        if(ch[i]=='-'){
            mag=-1;
            i++;
        }
        else if(ch[i]=='+'){
            mag=1;
            i++;
        }
        long res=0;
        while(i<n && Character.isDigit(ch[i])){
            int digit = ch[i] - '0';
            // if(mag>0 && res>Integer.MAX_VALUE/10 )return Integer.MAX_VALUE;
            // else if(mag>0 && res==Integer.MAX_VALUE/10 && ch[i]>'7')return Integer.MAX_VALUE;
            // else if(mag<0 && res>214748364)return Integer.MIN_VALUE;
            // else if(mag<0 && res==214748364 && ch[i]>'8')return Integer.MIN_VALUE;
            if(mag>0) {
                if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && digit>7)) return Integer.MAX_VALUE;
            } else {
                if(res>214748364 || (res==214748364 && digit>8)) return Integer.MIN_VALUE;
            }
            res=res*10+digit;
            i++;
        }
        return (int)(res*mag);
    }
}