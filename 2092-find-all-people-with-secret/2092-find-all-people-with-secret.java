class Solution {
    int[] parents;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        int m = meetings.length;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        join(0, firstPerson);
        for (int i = 0; i < m;) {
            int time = meetings[i][2];
            Set<Integer> set = new HashSet<>();
            while (i < m && meetings[i][2] == time) {
                join(meetings[i][0], meetings[i][1]);
                set.add(meetings[i][0]);
                set.add(meetings[i][1]);
                i++;
            }
            for (int person : set) {
                if (!isSame(0, person)) {
                    disJoin(person);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isSame(0, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    int find(int v) {
        return parents[v] == v ? v : (parents[v] = find(parents[v]));
    }

    void join(int v, int u) {
        v = find(v);
        u = find(u);
        if (u == v)
            return;
        parents[u] = v;
    }

    boolean isSame(int v, int u) {
        return find(v) == find(u);
    }

    void disJoin(int v) {
        parents[v] = v;
    }
}