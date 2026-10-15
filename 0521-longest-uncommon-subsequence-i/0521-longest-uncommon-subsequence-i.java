// class Solution {
//     public int findLUSlength(String a, String b) {
//         int c=0;
//         int count=-1;
//         int n1=a.length();
//         int n2=b.length();
//         int i=0;
//         while(i<n1){
//             c=0;
//             int j=i;
//             while(j<n1 && j<n2 && a.charAt(j)!=b.charAt(j)){
//                 c++;
//                 j++;
//             }
//             i=j+1;
//             count=Math.max(count,c);
//         }
//         return (count==0)?-1:count;
//     }
// }


class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}
