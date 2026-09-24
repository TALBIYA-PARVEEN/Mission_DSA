// class Solution {
//     public int countOfSubstrings(String word, int k) {
//         int n=word.length();
//         char[] c=word.toCharArray();
//         int left=0;
//         int consonant_cnt=0;
//         int cnt=0;
//         HashMap<Character,Integer> map=new HashMap<>(); 
//         for(int right=0;right<n;right++){
//             if(c[right]=='a' || c[right]=='e' || c[right]=='i'||c[right]=='o'||c[right]=='u' ){
//                 map.put(c[right],map.getOrDefault(c[right],0)+1);
//             }
//             else consonant_cnt++;
//             while(map.size()==5 && consonant_cnt==k){
//                 cnt++;
//                 if(c[left]=='a' || c[left]=='e' || c[left]=='i' || c[left]=='o' || c[left]=='u'){
//                     if(map.get(c[left]) == 1)
//                         map.remove(c[left]);
//                     else
//                         map.put(c[left], map.get(c[left]) - 1);
//                 }
//                 else consonant_cnt--;
//                 left++;
//             }
//             while(consonant_cnt>k){
//                 if(c[left]=='a' || c[left]=='e' || c[left]=='i' || c[left]=='o' || c[left]=='u'){
//                     if(map.get(c[left]) == 1)
//                         map.remove(c[left]);
//                     else
//                         map.put(c[left], map.get(c[left]) - 1);
//                 }
//                 else consonant_cnt--;
//                 left++;
//             }
//         }
//         while(left<n){
//             if(c[left]=='a' || c[left]=='e' || c[left]=='i' || c[left]=='o' || c[left]=='u'){
//                 if(map.get(c[left]) == 1)
//                     map.remove(c[left]);
//                 else
//                     map.put(c[left], map.get(c[left]) - 1);
//             }
//             else consonant_cnt--;
//             if(map.size()==5 && consonant_cnt==k)cnt++;
//             left++;
//         }
//         return cnt;
//     }
// }

class Solution {
    public int countOfSubstrings(String word, int k) {
        int n=word.length();
        char[] c=word.toCharArray();
        int cnt=0;
        for(int i=0;i<n;i++){
            int consonant_cnt=0;
            HashMap<Character,Integer> map=new HashMap<>(); 
           for(int j=i;j<n;j++){
                if(c[j]=='a' || c[j]=='e' || c[j]=='i'||c[j]=='o'||c[j]=='u' ){
                    map.put(c[j],map.getOrDefault(c[j],0)+1);
                }
                else consonant_cnt++;
                // if(consonant_cnt>k)break;
                if(map.size()==5 && consonant_cnt==k)cnt++;
           }
        }
        return cnt;
    }
}

