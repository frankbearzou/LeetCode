class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = List.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(op1 + op2);
                } else if ("-".equals(token)) {
                    stack.push(op1 - op2);
                } else if ("*".equals(token)) {
                    stack.push(op1 * op2);
                } else if ("/".equals(token)) {
                    stack.push(op1 / op2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}