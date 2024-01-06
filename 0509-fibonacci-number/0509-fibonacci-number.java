class Solution {
    public int fib(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return fib(n, cache);
    }

    int fib(int n, Map<Integer, Integer> cache) {
        if (n <= 1)
            return n;
        if (cache.containsKey(n))
            return cache.get(n);
        int ret = fib(n - 1) + fib(n - 2);
        cache.put(n, ret);
        return ret;
    }
}