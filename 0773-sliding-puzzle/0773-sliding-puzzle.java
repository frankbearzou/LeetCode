class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        StringBuilder init = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                init.append(board[i][j]);
            }
        }
        String target = "123450";
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(init.toString());
        visited.add(init.toString());
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.remove();
                if (cur.equals(target))
                    return count;
                int zero = cur.indexOf('0');
                for (int newpos : dirs[zero]) {
                    String newState = swap(cur, zero, newpos);
                    if (visited.contains(newState))
                        continue;
                    queue.add(newState);
                    visited.add(newState);
                }
            }
            count++;
        }
        return -1;
    }

    String swap(String cur, int zero, int newpos) {
        StringBuilder res = new StringBuilder(cur);
        res.setCharAt(zero, cur.charAt(newpos));
        res.setCharAt(newpos, cur.charAt(zero));
        return res.toString();
    }
}