import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        long mask1 = 0; 
        long mask2 = 0; 
        
        for (int num : nums) {
            if (num <= 64) {
                mask1 |= (1L << (num - 1));
            } else {
                mask2 |= (1L << (num - 65));
            }
        }
        for (int i = min; i <= max; i++) {
            if (i <= 64) {
                if ((mask1 & (1L << (i - 1))) == 0) {
                    missing.add(i);
                }
            } else {
                if ((mask2 & (1L << (i - 65))) == 0) {
                    missing.add(i);
                }
            }
        }
        
        return missing;
    }
}
