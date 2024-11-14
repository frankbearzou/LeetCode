/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int l = 1, r = 1000;
            while (l <= r) {
                int m = l + (r - l) / 2;
                int ret = customfunction.f(x, m);
                if (ret == z) {
                    ans.add(List.of(x, m));
                    break;
                } else if (ret < z) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return ans;
    }
}