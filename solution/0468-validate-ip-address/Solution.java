class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return ipv4(IP);
        } else if (IP.contains(":")) {
            return ipv6(IP);
        } else {
            return "Neither";
        }
    }
    
    private String ipv4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.')
            return "Neither";
        String[] split = IP.split("\\.");
        if (split.length != 4)
            return "Neither";
        for (String s : split) {
            if (s.length() == 0 || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0'))
                return "Neither";
            for (char c : s.toCharArray()) {
                if (!(c >= '0' && c <= '9'))
                    return "Neither";
            }
            int val = 0;
            try {
                val = Integer.valueOf(s);
            } catch (NumberFormatException e) {
                return "Neither";
            }
            if (val < 0 || val > 255)
                return "Neither";
        }
        return "IPv4";
    }
    
    private String ipv6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':')
            return "Neither";
        String[] split = IP.split(":");
        if (split.length != 8)
            return "Neither";
        for (String s : split) {
            if (s.length() == 0 || s.length() > 4)
                return "Neither";
            for (char c : s.toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                    return "Neither";
            }
        }
        return "IPv6";
    }
}
