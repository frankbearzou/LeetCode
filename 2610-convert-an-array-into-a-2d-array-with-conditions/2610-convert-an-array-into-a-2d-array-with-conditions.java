class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] map = new int[nums.length + 1];
        for (int num : nums) {
            if (map[num] == ans.size()) {
                ans.add(new ArrayList());
            }
            ans.get(map[num]).add(num);
            map[num]++;
        }
        return ans;
    }
}