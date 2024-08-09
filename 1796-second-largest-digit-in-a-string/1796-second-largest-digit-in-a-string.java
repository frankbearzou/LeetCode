class Solution {
    public int secondHighest(String s) {
        int largest = -1, larger = -1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int d = c - '0';
                if (d > largest) {
                    larger = largest;
                    largest = d;
                } else if (d != largest && d > larger) {
                    larger = d;
                }
            }
        }
        return larger;
    }
}