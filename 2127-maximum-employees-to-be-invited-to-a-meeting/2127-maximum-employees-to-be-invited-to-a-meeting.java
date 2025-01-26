class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int f : favorite) {
            inDegree[f]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int next = favorite[cur];
            depth[next] = Math.max(depth[next], depth[cur] + 1);
            if (--inDegree[next] == 0)
                queue.add(next);
        }
        int two = 0, longest = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                continue;
            int len = 0, cur = i;
            while (inDegree[cur] != 0) {
                inDegree[cur] = 0;
                len++;
                cur = favorite[cur];
            }
            if (len == 2) {
                two += depth[i] + depth[favorite[i]];
            } else {
                longest = Math.max(longest, len);
            }
        }
        return Math.max(two, longest);
    }
}