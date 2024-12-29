class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int zero = 0, one = 0;
        for (int stu : students) {
            if (stu == 0)
                zero++;
            else
                one++;
        }
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0) {
                if (zero > 0)
                    zero--;
                else
                    return n - i;
            } else {
                if (one > 0)
                    one--;
                else
                    return n - i;
            }
        }
        return 0;
    }
}