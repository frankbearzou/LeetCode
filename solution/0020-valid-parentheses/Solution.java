class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (!stack.empty()) {
                    char pop = stack.pop();
                    if (!((pop == '(' && s.charAt(i) == ')') || (pop == '[' && s.charAt(i) == ']') || (pop == '{' && s.charAt(i) == '}')))
                        return false;
                } else
                    return false;
            }
        }
        return stack.empty();
    }
}
