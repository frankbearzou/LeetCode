class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> unused = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unused.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            unused.add(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!unused.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}