class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int cur = 0, last = 0;
        
        while (last < len) {
            if (arr[cur++] != 0) {
                last++;
            } else {
                last = last + 2;
            }
        }
        if (last > len) {
            cur -= 2;
            last = last - 3;
            arr[len - 1] = 0;
        } else {
            cur -= 1;
            last = last - 1;
        }
        while (cur >= 0 && cur < last) {
            if (arr[cur] != 0) {
                arr[last] = arr[cur];
                cur--;
                last--;
            } else {
                cur--;
                arr[last--] = 0;
                arr[last--] = 0;
            }
        }
    }
}
