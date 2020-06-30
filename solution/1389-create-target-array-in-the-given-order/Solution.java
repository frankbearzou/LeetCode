class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
