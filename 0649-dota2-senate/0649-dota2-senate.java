class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> r = new ArrayDeque<>();
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                r.offer(i);
            else
                d.offer(i);
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() < d.peek()) {
                r.offer(n++);
            } else {
                d.offer(n++);
            }
            r.poll();
            d.poll();
        }
        return !r.isEmpty() ? "Radiant" : "Dire";
    }
}