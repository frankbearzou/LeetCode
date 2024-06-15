class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n && projects[index].capital <= w) {
                pq.offer(projects[index++].profits);
            }
            if (pq.isEmpty())
                break;
            w += pq.poll();
        }
        return w;
    }
}

class Project {
    int profits;
    int capital;
    Project(int profits, int capital) {
        this.profits = profits;
        this.capital = capital;
    }
}