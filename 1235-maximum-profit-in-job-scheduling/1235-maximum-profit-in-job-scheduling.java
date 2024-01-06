class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
        Map<Integer, Integer> cache = new HashMap<>();
        return dfs(jobs, 0, cache);
    }

    int dfs(Job[] jobs, int i, Map<Integer, Integer> cache) {
        if (i >= jobs.length)
            return 0;
        if (cache.containsKey(i))
            return cache.get(i);
        // not choose
        int res = dfs(jobs, i + 1, cache);
        // choose
        int next = i + 1;
        while (next < jobs.length) {
            if (jobs[i].endTime <= jobs[next].startTime)
                break;
            next++;
        }
        res = Math.max(res, jobs[i].profit + dfs(jobs, next, cache));
        cache.put(i, res);
        return res;
    }
}

class Job {
    int startTime;
    int endTime;
    int profit;
    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit= profit;
    }
}