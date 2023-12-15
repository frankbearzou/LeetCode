class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] set1 = new int[1001];
        int[] set2 = new int[1001];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set1[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            set2[nums2[i]] = 1;
        }
        for (int i = 0; i < set1.length; i++) {
            if (set1[i] == 1 && set2[i] == 1) {
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