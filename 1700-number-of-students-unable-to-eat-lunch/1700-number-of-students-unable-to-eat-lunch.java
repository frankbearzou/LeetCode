class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] map = new int[2];
        Deque<Integer> student = new ArrayDeque<>(), sandwich = new ArrayDeque<>();
        for (int s : students) {
            student.offer(s);
            map[s]++;
        }
        for (int s : sandwiches)
            sandwich.offer(s);
        while (!sandwich.isEmpty()) {
            int top = sandwich.peek();
            if (map[top] == 0)
                return student.size();
            while (!student.isEmpty()) {
                if (student.peek() != top)
                    student.offer(student.poll());
                else {
                    student.poll();
                    sandwich.poll();
                    map[top]--;
                    break;
                }
            }
        }
        return 0;
    }
}