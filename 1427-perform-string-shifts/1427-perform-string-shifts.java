class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (int[] sh : shift) {
            if (sh[0] == 0) {
                count -= sh[1];
            } else {
                count += sh[1];
            }
        }
        for (char c : s.toCharArray()) {
            deque.add(c);
        }
        if (count == 0) {
            return s;
        } else if (count < 0) {
            while (count++ < 0)
                deque.add(deque.remove());
        } else {
            while (count-- > 0)
                deque.addFirst(deque.removeLast());
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.remove());
        }
        return sb.toString();
    }
}