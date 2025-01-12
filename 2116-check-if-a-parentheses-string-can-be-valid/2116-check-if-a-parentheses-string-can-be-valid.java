class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1)
            return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlock = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            char l = locked.charAt(i);
            if (l == '0') {
                unlock.push(i);
            } else if (c == '(') {
                open.push(i);
            } else if (c == ')') {
                if (!open.isEmpty())
                    open.pop();
                else if (!unlock.isEmpty())
                    unlock.pop();
                else
                    return false;
            }
        }
        while (!open.isEmpty() && !unlock.isEmpty() && open.peek() < unlock.peek()) {
            open.pop();
            unlock.pop();
        }
        return open.isEmpty();
    }
}