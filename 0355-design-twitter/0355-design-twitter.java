class Twitter {
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int timestamp;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, timestamp++});
        followMap.putIfAbsent(userId, new HashSet<>());
        if (!followMap.get(userId).contains(userId)) {
            followMap.get(userId).add(userId);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Set<Integer> followees = followMap.get(userId);
        if (followees == null)
            return list;
        for (int followee : followees) {
            List<int[]> tweets = tweetMap.get(followee);
            if (tweets != null) {
                int n = tweets.size();
                while (n-- > 0) {
                    pq.offer(tweets.get(n));
                }
            }
        }
        int n = Math.min(10, pq.size());
        while (n-- > 0) {
            list.add(pq.poll()[0]);
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) == null)
            return;
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */