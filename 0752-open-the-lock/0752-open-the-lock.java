class Solution {
    public int openLock(String[] deadends, String target) {
        int turn = 0;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        visited.add("0000");
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(target))
                    return turn;
                for (int i = 0; i < 4; i++) {
                    char c = cur.charAt(i);
                    String next = cur.substring(0, i) + (c == '9' ? '0' : (char)(c + 1)) + cur.substring(i + 1);
                    String pre = cur.substring(0, i) + (c == '0' ? '9' : (char)(c - 1)) + cur.substring(i + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                    if (!visited.contains(pre)) {
                        visited.add(pre);
                        queue.offer(pre);
                    }
                }
            }
            turn++;
        }
        return -1;
    }
}