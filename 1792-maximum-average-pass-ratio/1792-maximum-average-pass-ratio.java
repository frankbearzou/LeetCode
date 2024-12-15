class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] cla : classes) {
            int stu = cla[0];
            int total = cla[1];
            queue.add(new double[]{calc(stu, total), stu, total});
        }
        while (extraStudents-- > 0) {
            double[] top = queue.remove();
            top[1]++;
            top[2]++;
            queue.add(new double[]{calc((int)top[1], (int)top[2]), top[1], top[2]});
        }
        double ans = 0;
        for (double[] q : queue) {
            ans += 1.0 * q[1] / q[2];
        }
        return ans / classes.length;
    }

    double calc(int stu, int total) {
        return 1.0 * (stu + 1) / (total + 1) - (1.0 * stu / total);
    }
}