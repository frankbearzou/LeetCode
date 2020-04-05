class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                if (s.equals("+"))
                    res = a + b;
                else if (s.equals("-"))
                    res = a - b;
                else if (s.equals("*"))
                    res = a * b;
                else if (s.equals("/"))
                    res = a / b;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int res = stack.pop();
        return res;
    }
}
