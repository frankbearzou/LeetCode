class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                list.add(nums[j]);
            }
            Collections.sort(list);
            int diff = list.get(1) - list.get(0);
            boolean same = true;
            for (int j = 2; j < list.size(); j++) {
                if (list.get(j) - list.get(j - 1) != diff) {
                    same = false;
                    break;
                }
            }
            ans.add(same);
        }
        return ans;
    }
}