class Solution {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        if (rungs[0] > dist)
            count += (rungs[0] - 1) / dist;
        for (int i = 0; i < rungs.length - 1; i++) {
            count += (rungs[i + 1] - rungs[i] - 1) / dist;
        }
        return count;
    }
}