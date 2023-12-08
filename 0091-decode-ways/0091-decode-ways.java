class Solution {
    public int numDecodings(String s) {
        Integer[] cache = new Integer[s.length()];
        return numDecodings(s.toCharArray(), 0, cache);
    }

    int numDecodings(char[] arr, int i, Integer[] cache) {
        if (i >= arr.length)
            return 1;
        if (arr[i] == '0')
            return 0;
        if (cache[i] != null)
            return cache[i];
        int res = numDecodings(arr, i + 1, cache);
        if (i + 1 < arr.length && (arr[i] == '1' || (arr[i] == '2' && arr[i + 1] <= '6')))
            res += numDecodings(arr, i + 2, cache);
        cache[i] = res;
        return res;
    }
}