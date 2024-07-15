class Solution {
    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.offer(c);
            } else {
                if (isBad(deque.peekLast(), c)) {
                    deque.pollLast();
                } else {
                    deque.offer(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.poll());
        }
        return res.toString();
    }

    boolean isBad(char a, char b) {
        return a + 32 == b || a - 32 == b;
    }
}