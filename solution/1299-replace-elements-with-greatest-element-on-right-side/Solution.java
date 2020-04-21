class Solution {
    public int[] replaceElements(int[] arr) {
        int val = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                val = arr[i];
                arr[i] = -1;
            } else {
                if (arr[i] > val) {
                    int tmp = arr[i];
                    arr[i] = val;
                    val = tmp;
                } else {
                    arr[i] = val;
                }
            }
        }
        
        return arr;
    }
}
