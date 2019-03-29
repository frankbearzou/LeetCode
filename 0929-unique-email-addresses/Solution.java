class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String domain = split[0];
            int hasPlus = split[0].indexOf('+');
            if (hasPlus != -1)
                domain = split[0].substring(0, hasPlus);
            domain = domain.replaceAll("\\.", "");
            set.add(domain + "@" + split[1]);
        }
        return set.size();
    }
}
