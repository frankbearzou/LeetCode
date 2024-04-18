class Solution {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        String day = getDay(split[0]);
        String month = getMonth(split[1]);
        String year = split[2];
        return String.format("%s-%s-%s", year, month, day);
    }

    String getDay(String s) {
        s = s.substring(0, s.length() - 2);
        if (s.length() == 1)
            s = "0" + s;
        return s;
    }

    String getMonth(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        return map.get(s);
    }
}