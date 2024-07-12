class Solution {
    int sum = 0;

    public int maximumGain(String s, int x, int y) {
        int highScore = 0, lowScore = 0;
        String high = "", low = "";
        if (x >= y) {
            highScore = x;
            lowScore = y;
            high = "ab";
            low = "ba";
        } else {
            highScore = y;
            lowScore = x;
            high = "ba";
            low = "ab";
        }
        s = count(s, high, highScore);
        s = count(s, low, lowScore);
        return sum;
    }

    String count(String s, String str, int score) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == str.charAt(0) && c == str.charAt(1)) {
                sum += score;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}