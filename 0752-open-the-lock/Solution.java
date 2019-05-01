class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String begin = queue.poll();
                if (begin.equals(target))
                    return level;
                if (visited.contains(begin))
                    continue;
                visited.add(begin);
                List<String> next = getNextStep(begin);
                queue.addAll(next);
            }
            ++level;
        }
        
        return -1;
    }
    
    List<String> getNextStep(String s) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i) + (s.charAt(i) == '9' ? 0 : s.charAt(i) - '0' + 1) + s.substring(i + 1);
            String s2 = s.substring(0, i) + (s.charAt(i) == '0' ? 9 : s.charAt(i) - '0' - 1) + s.substring(i + 1);
            list.add(s1);
            list.add(s2);
        }
        return list;
    }
}
