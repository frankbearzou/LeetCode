class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int first = 0, second = 0, res = 0;
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                second = stack.pop();
                first = stack.pop();
                if ("+".equals(token))
                    res = first + second;
                if ("-".equals(token))
                    res = first - second;
                if ("*".equals(token))
                    res = first * second;
                if ("/".equals(token))
                    res = first / second;
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}