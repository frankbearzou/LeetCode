class Solution {
    public int maximumPopulation(int[][] logs) {
        int min = 2051, max = 0;
        for (int[] log : logs) {
            min = Math.min(min, log[0]);
            max = Math.max(max, log[1]);
        }
        int year = 0;
        int res = 0;
        for (int i = min; i < max; i++) {
            int count = 0;
            for (int j = 0; j < logs.length; j++) {
                if (i >= logs[j][0] && i < logs[j][1])
                    count++;
            }
            if (count > res) {
                res = count;
                year = i;
            }
        }
        return year;
    }
}