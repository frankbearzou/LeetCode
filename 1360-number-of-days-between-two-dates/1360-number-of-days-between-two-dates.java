class Solution {
    int[] mon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    int daysFrom1971(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        if (month > 2 && isLeapYear(year))
            day++;
        for (int i = 0; i < month - 1; i++) {
            day += mon[i];
        }
        return (year - 1971) * 365 + countLeapYear(year) + day;
    }

    int countLeapYear(int year) {
        int count = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i))
                count++;
        }
        return count;
    }

    boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}