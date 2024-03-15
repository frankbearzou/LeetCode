class Solution {
    public int dayOfYear(String date) {
        int count = 0;
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        if (year % 100 == 0) {
            if (year % 400 == 0)
                arr[1] = 29;
        } else if (year % 4 == 0) {
            arr[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            count += arr[i];
        }
        count += day;
        return count;
    }
}