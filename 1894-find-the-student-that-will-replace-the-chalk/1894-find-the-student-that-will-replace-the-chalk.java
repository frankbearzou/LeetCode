class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int n = chalk.length;
        int sum = 0;
        for (int c : chalk)
            sum += c;
        k = k % sum;
        while (k >= 0) {
            if (chalk[i] > k)
                return i;
            k -= chalk[i];
            i++;
            if (i % n == 0)
                i = 0;
        }
        return i;
    }
}