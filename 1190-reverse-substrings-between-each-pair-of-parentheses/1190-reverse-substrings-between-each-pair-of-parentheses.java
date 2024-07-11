class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c ==')') {
                while (stack.peek() != '(') {
                    q.offer(stack.pop());
                }
                stack.pop();
                while (!q.isEmpty()) {
                    stack.push(q.poll());
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}