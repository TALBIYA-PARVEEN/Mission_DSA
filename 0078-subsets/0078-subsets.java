class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        int i=0;
        ArrayList<Integer> temp=new ArrayList<>();
        recursion(nums,i,temp,ans);
        return ans;
    }
    public void recursion(int[] nums, int i,List<Integer> temp,List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        recursion(nums,i+1,temp,ans);
        temp.remove(temp.size()-1);
        recursion(nums,i+1,temp,ans);
    }
}