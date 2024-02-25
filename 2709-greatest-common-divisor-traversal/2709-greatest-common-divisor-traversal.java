class Solution {
    int[] parents;
    int[] rank;

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1)
            return true;
        int maxValue = 0;
        for (int num : nums) {
            if (num == 1)
                return false;
            maxValue = Math.max(maxValue, num);
        }
        parents = new int[maxValue + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        rank = new int[parents.length];
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    union(num, i);
                    union(num, num / i);
                }
            }
        }
        int parent0 = find(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (!isSame(parent0, nums[i]))
                return false;
        }
        return true;
    }

    int find(int u) {
        return parents[u] == u ? u : (parents[u] = find(parents[u]));
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu != pv) {
            if (rank[pu] > rank[pv]) {
                parents[pv] = pu;
            } else if (rank[pv] > rank[pu]) {
                parents[pu] = pv;
            } else {
                rank[pu]++;
                parents[pv] = pu;
            }
        }
    }

    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }
}