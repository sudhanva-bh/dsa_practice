import java.util.*;

/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 */

// @lc code=start
class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i <= turnedOn; i++){
            int hoursTurnedOn = i, minutesTurnedOn = turnedOn - i;
            if(hoursTurnedOn > 4 || minutesTurnedOn > 6) return result;
            List<String> possibleHours = new ArrayList<>();
            List<String> possibleMins = new ArrayList<>();
            
            for(Integer h = 0; h < (1 << hoursTurnedOn); h++){
                if(Integer.bitCount(h) == hoursTurnedOn){
                    
                }
            }
        }
    }
}
// @lc code=end

