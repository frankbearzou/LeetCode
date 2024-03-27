class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int ruleId = 0;
        if ("type".equals(ruleKey))
            ruleId = 0;
        else if ("color".equals(ruleKey))
            ruleId = 1;
        else if ("name".equals(ruleKey))
            ruleId = 2;
        for (List<String> item : items) {
            if (item.get(ruleId).equals(ruleValue))
                count++;
        }
        return count;
    }
}