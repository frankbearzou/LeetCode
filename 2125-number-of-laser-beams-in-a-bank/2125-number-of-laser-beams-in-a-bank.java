class Solution {
    public int numberOfBeams(String[] bank) {
        int first = 0, sum = 0;
        for (int i = 0; i < bank.length; i++) {
            int laser = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1')
                    laser++;
            }
            if (laser > 0) {
                if (first == 0) {
                    first = laser;
                } else {
                    sum += first * laser;
                    first = laser;
                }
            }
        }
        return sum;
    }
}