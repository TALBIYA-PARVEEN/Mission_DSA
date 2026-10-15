

class Solution {
    public String reverseOnlyLetters(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ch = s.toCharArray();

        while (l < r) {
            if (!Character.isLetter(ch[l])) {
                l++;
            } else if (!Character.isLetter(ch[r])) {
                r--;
            } else {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;

                l++;
                r--;
            }
        }

        return new String(ch);
    }
}
