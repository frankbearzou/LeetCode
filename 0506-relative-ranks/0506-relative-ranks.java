class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        Map<Integer, String> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int s : score) {
            queue.offer(s);
        }
        for (int i = 0; i < score.length; i++) {
            map.put(queue.poll(), String.valueOf(i + 1));
        }
        for (int i = 0; i < score.length; i++) {
            String value = map.get(score[i]);
            if (value.equals("1"))
                value = "Gold Medal";
            else if (value.equals("2"))
                value = "Silver Medal";
            else if (value.equals("3"))
                value = "Bronze Medal";
            res[i] = value;
        }
        return res;
    }
}