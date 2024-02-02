class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String num = "123456789";
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();
        while (min <= max) {
            for (int i = 0; i + min <= 9; i++) {
                int val = Integer.parseInt(num.substring(i, i + min));
                if (val < low) {
                    continue;
                } else if (val > high) {
                    break;
                } else {
                    ans.add(val);
                }
            }
            min++;
        }
        return ans;
    }
}