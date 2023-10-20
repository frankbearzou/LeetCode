class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != ')') {
                    return false;
                }
                if (c == ']' && pop != ']') {
                    return false;
                }
                if (c == '}' && pop != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}