class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        if (map.containsKey(N))
            return map.get(N);
        int result = fib(N - 1) + fib(N - 2);
        map.put(N, result);
        return result;
    }
}
