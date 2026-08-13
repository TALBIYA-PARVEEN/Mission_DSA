class Solution {
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> ans = new HashSet<>();

    List<Integer> temp = new ArrayList<>();

    recursion(nums, 0, temp, ans);

    return new ArrayList<>(ans);
}

public void recursion(
    int[] nums,
    int i,
    List<Integer> temp,
    Set<List<Integer>> ans
) {

    if (i == nums.length) {
        ans.add(new ArrayList<>(temp));
        return;
    }

    // Take nums[i]
    temp.add(nums[i]);

    recursion(nums, i + 1, temp, ans);

    // Backtrack
    temp.remove(temp.size() - 1);

    // Don't take nums[i]
    recursion(nums, i + 1, temp, ans);
}
}