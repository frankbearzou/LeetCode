class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] map = new int[nums.length + 1];
        int count = 0;
        for (int num : nums) {
            map[num]++;
            count++;
        }
        while (count > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    list.add(i);
                    map[i]--;
                    count--;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}