class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int[] login = getTime(loginTime);
        int loginHour = login[0];
        int loginMin = login[1];
        int[] logout = getTime(logoutTime);
        int logoutHour = logout[0];
        int logoutMin = logout[1];
        if (loginHour == logoutHour && loginMin == logoutMin)
            return 0;
        if (loginHour < logoutHour || ((loginHour == logoutHour) && (loginMin < logoutMin))) {
            return getEnd(logoutHour, logoutMin) - getStart(loginHour, loginMin);
        }
        return getEnd(24, 0) - getStart(loginHour, loginMin) + getEnd(logoutHour, logoutMin) - getStart(0, 0);
    }

    int[] getTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return new int[]{hour, min};
    }

    int getStart(int hour, int min) {
        int total = hour * 4;
        int m = 0;
        if (min > 0 && min <= 15)
            m = 1;
        else if (min > 15 && min <= 30)
            m = 2;
        else if (min > 30 && min <= 45)
            m = 3;
        else if (min > 45)
            m = 4;
        return total + m;
    }

    int getEnd(int hour, int min) {
        int total = hour * 4;
        int m = 0;
        if (min >= 15 && min < 30)
            m = 1;
        else if (min >= 30 && min < 45)
            m = 2;
        else if (min >= 45)
            m = 3;
        return total + m;
    }
}