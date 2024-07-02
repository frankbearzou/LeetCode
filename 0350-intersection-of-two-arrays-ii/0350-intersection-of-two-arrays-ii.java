class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for (int i : nums1) {
            map1[i]++;
        }
        for (int i : nums2) {
            map2[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] > 0 && map2[i] > 0) {
                int count = Math.min(map1[i], map2[i]);
                while (count-- > 0)
                    list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}