class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peek() > c) {
                deque.pop();
                k--;
            }
            deque.push(c);
        }
        while (!deque.isEmpty() && k-- > 0) {
            deque.pop();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollLast();
            if (leadingZero && c == '0')
                continue;
            leadingZero = false;
            res.append(c);
        }
        if (res.length() == 0)
            return "0";
        return res.toString();
    }
}