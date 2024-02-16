class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        while (i < N && j < N) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }
        while (j < N) {
            if (stack.pop() != popped[j++])
                return false;
        }
        return true;
    }
}