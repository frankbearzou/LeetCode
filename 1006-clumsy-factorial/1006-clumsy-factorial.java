class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        int op = 0;
        stack.push(n);
        for (int i = n - 1; i >= 1; i--) {
            if (op == 0)
                stack.push(stack.pop() * i);
            else if (op == 1)
                stack.push(stack.pop() / i);
            else if (op == 2)
                stack.push(stack.pop() + i);
            else {
                if (stack.size() > 1)
                    stack.push(stack.pop() + stack.pop());
                stack.push(-i);
            }
            op = (op + 1) % 4;
        }
        if (stack.size() == 1)
            return stack.pop();
        return stack.pop() + stack.pop();
    }
}