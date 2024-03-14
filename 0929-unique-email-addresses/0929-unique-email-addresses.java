class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            StringBuilder localname = new StringBuilder();
            for (char c : split[0].toCharArray()) {
                if (c == '+')
                    break;
                if (c == '.')
                    continue;
                localname.append(c);
            }
            set.add(localname.toString() + "@" + split[1]);
        }
        return set.size();
    }
}