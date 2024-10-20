class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                List<Character> exp = new ArrayList<>();
                while (stack.peek() != '(') {
                    exp.add(stack.pop());
                }
                stack.pop(); // pop (
                char op = stack.pop();
                char res = eval(op, exp);
                stack.push(res);
            } else if (c != ',')
                stack.push(c);
        }
        return stack.peek() == 't';
    }

    char eval(char op, List<Character> exp) {
        if (op == '!')
            return exp.getFirst() == 'f' ? 't' : 'f';
        if (op == '&') {
            for (char c : exp) {
                if (c == 'f')
                    return 'f';
            }
            return 't';
        }
        if (op == '|') {
            for (char c : exp) {
                if (c == 't')
                    return 't';
            }
            return 'f';
        }
        return 'f';
    }
}