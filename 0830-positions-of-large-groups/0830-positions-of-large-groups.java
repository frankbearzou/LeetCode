class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        int pos = 0, n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[pos] != arr[i]) {
                if (i - pos >= 3) {
                    ans.add(List.of(pos, i - 1));
                }
                pos = i;
            }
        }
        if (n - pos >= 3)
            ans.add(List.of(pos, n - 1));
        return ans;
    }
}