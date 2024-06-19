class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String str = "123456789";
        int lowDigit = String.valueOf(low).length();
        int highDigit = String.valueOf(high).length();
        for (int d = lowDigit; d <= highDigit; d++) {
            for (int i = String.valueOf(low).charAt(0) - '1'; i + d <= str.length(); i++) {
                int value = Integer.parseInt(str.substring(i, i + d));
                if (value > high)
                    break;
                res.add(value);
            }
        }
        return res;
    }
}