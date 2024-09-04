class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int dir = 0;
        int x0 = 0, y0 = 0;
        Set<Pair<Integer, Integer>> block = new HashSet<>();
        for (int[] obstacle : obstacles) {
            block.add(new Pair(obstacle[0], obstacle[1]));
        }
        for (int cmd : commands) {
            int x = 0, y = 0;
            if (cmd == -1) {
                dir += 1;
                dir = dir % 4;
            } else if (cmd == -2) {
                dir += 3;
                dir = dir % 4;
            }
            if (dir == 0) {
                y = 1;
            } else if (dir == 1) {
                x = 1;
            } else if (dir == 2) {
                y = -1;
            } else if (dir == 3) {
                x = -1;
            }
            for (int i = 0; i < cmd; i++) {
                int x1 = x0 + x;
                int y1 = y0 + y;
                if (block.contains(new Pair(x1, y1)))
                    break;
                x0 += x;
                y0 += y;
                res = Math.max(res, x0 * x0 + y0 * y0);
            }
        }
        return res;
    }
}