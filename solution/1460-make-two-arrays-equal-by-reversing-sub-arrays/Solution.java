class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucket = new int[1001];
        
        for (int i = 0; i < arr.length; i++) {
            bucket[target[i]]++;
            bucket[arr[i]]--;
        }
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] != 0)
                return false;
        }
        return true;
    }
}
