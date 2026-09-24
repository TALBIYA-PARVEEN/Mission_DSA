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
//         }
//         return cnt;
//     }
// }

class Solution {
    public int countOfSubstrings(String word, int k) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            String str = "";
            for (int j = i; j < word.length(); j++) {
                str = str + word.charAt(j);
                if (str.length() >= 5 && isVowel(str) && isCons(str, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isVowel(String str) {
        if (str.contains("" + 'a') && str.contains("" + 'e') &&
                str.contains("" + 'i') && str.contains("" + 'o') &&
                str.contains("" + 'u')) {
                    return true;
        }
        return false;
    }
    public static boolean isCons(String str, int k){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch != 'a' && ch != 'e' && ch != 'i' &&
             ch != 'o' && ch != 'u'){
                count++;
                if(count > k){
                    return false;
                }
             }
        }
        if(k > count){
            return false;
        }else{
            return true;
        }
    }
}