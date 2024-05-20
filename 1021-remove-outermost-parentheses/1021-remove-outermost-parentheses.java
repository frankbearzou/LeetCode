class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                queue.offer(c);
            } else {
                count--;
                if (count > 0) {
                    queue.offer(c);
                } else {
                    queue.poll();
                    while (!queue.isEmpty()) {
                        res.append(queue.poll());
                    }
                }
            }
        }
        return res.toString();
    }
}