class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            int ten = detail.charAt(11) - '0';
            if (ten > 6) {
                count++;
            } else if (ten == 6) {
                int one = detail.charAt(12) - '0';
                if (one > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}