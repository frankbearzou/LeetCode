class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int len = Math.abs(arr[1] - arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (abs < len) {
                result.clear();
                len = abs;
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (abs == len) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}
