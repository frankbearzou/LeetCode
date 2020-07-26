class Solution {
    public String generateTheString(int n) {
        char[] arr = new char[n];
        if (n % 2 == 0) 
            arr[0] = 'a';
        int start = (n % 2 == 0) ? 1 : 0;
        for (int i = start; i < n; i++) {
            arr[i] = 'b';
        }
        
        return new String(arr);
    }
}
