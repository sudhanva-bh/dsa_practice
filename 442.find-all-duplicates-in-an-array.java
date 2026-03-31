
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int x = Math.abs(nums[i]);
            if(nums[x - 1] < 0){
                duplicates.add(x);
            }
            nums[x - 1] = -nums[x - 1];
        }
        return duplicates;
    }
}
// @lc code=end

