class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int pointPerSide = n + 1;
        int totalPoints = (n + 1) * (n + 1);
        int[] parent = new int[totalPoints];
        Arrays.fill(parent, -1);
        // boarder's parent is top left point 0
        for (int i = 0; i < pointPerSide; i++) {
            for (int j = 0; j < pointPerSide; j++) {
                if (i == 0 || j == 0 || i == pointPerSide - 1 || j == pointPerSide - 1) {
                    int p = i * pointPerSide + j;
                    parent[p] = 0;
                }
            }
        }
        // top left point's parent is self
        parent[0] = -1;
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    int topRight = i * pointPerSide + (j + 1);
                    int bottomLeft = (i + 1) * pointPerSide + j;
                    res += union(parent, topRight, bottomLeft);
                } else if (grid[i].charAt(j) == '\\') {
                    int topLeft = i * pointPerSide + j;
                    int bottomRight = (i + 1) * pointPerSide + (j + 1);
                    res += union(parent, topLeft, bottomRight);
                }
            }
        }
        return res;
    }

    int find(int[] parent, int node) {
        return (parent[node] == -1) ? node : (parent[node] = find(parent, parent[node]));
    }

    int union(int[] parent, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        if (p1 == p2)
            return 1;
        parent[p2] = p1;
        return 0;
    }
}