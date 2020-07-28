class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int rCounter = 0;
        
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    rCounter++;
            }
        }
        
        return stack.size() + rCounter;
    }
}
