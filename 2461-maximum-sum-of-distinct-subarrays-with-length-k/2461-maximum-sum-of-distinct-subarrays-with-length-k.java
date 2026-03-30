import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            map.put(val, map.getOrDefault(val, 0) + 1);
            sum += val;
            while (map.get(val) > 1) {
                int leftVal = nums[left++];
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) map.remove(leftVal);
                sum -= leftVal;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
                int leftVal = nums[left++];
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) map.remove(leftVal);
                sum -= leftVal;
            }
        }
        return max;
    }
}