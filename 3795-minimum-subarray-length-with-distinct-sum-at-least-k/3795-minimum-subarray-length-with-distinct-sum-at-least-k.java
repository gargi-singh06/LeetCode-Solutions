import java.util.*;
class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int distinctSum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) {
                distinctSum += val;
            }
            while (distinctSum >= k) {
                res = Math.min(res, right - left + 1);
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) {
                    distinctSum -= leftVal;
                    freq.remove(leftVal);
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}