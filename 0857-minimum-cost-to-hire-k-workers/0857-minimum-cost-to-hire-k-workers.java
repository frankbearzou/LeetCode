class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentCost = 0;
        List<Pair<Double, Integer>> rates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rates.add(new Pair(1.0 * wage[i] / quality[i], quality[i]));
        }
        Collections.sort(rates, (a, b) -> Double.compare(a.getKey(), b.getKey()));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            double rate = rates.get(i).getKey();
            int WorkerQuality = rates.get(i).getValue();
            currentCost += WorkerQuality;
            queue.offer(WorkerQuality);
            if (queue.size() > k) {
                currentCost -= queue.poll();
            }
            if (queue.size() == k) {
                totalCost = Math.min(totalCost, currentCost * rate);
            }
        }
        return totalCost;
    }
}