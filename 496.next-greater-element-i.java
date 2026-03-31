
import java.util.*;

/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        int n = nums2.length;
        for(int i = n - 1; i >= 0; i--){
            while(stack.peek() <= nums2[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                hashMap.put(nums2[i], -1);
            } else {
                hashMap.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        n = nums1.length
        for(int i = 0; i < n; i++){
            nums1[i] = hashMap.get(nums[i]);
        }
        return nums1;
    }
}
// @lc code=end

