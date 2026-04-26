/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start

import java.util.*;

class Twitter {
    class Tweet {
        int tid, time;
        Tweet prev;

        Tweet(int tid, int time) {
            this.tid = tid;
            this.time = time;
            this.prev = null;
        }
    }

    Map<Integer, Tweet> tweetHM = new HashMap<>();
    Map<Integer, HashSet<Integer>> followHM = new HashMap<>();
    int timestamp = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timestamp++);

        if (tweetHM.containsKey(userId)) {
            newTweet.prev = tweetHM.get(userId);
        }

        tweetHM.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        followHM.putIfAbsent(userId, new HashSet<>());
        HashSet<Integer> userFollows = followHM.get(userId);

        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        userFollows.add(userId);

        for (Integer followeeId : userFollows) {
            Tweet tweetHead = tweetHM.get(followeeId);
            if (tweetHead != null) {
                pq.add(tweetHead);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty())
                break;
            Tweet temp = pq.poll();
            result.add(temp.tid);
            if (temp.prev != null)
                pq.add(temp.prev);
        }

        userFollows.remove(userId);

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followHM.putIfAbsent(followerId, new HashSet<>());
        followHM.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followHM.containsKey(followerId)) {
            followHM.get(followerId).remove(followeeId);
        }
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
// @lc code=end
