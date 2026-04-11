import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int res = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 3) continue;
            for (int i = 0; i <= size - 3; i++) {
                int min = list.get(i);
                int max = list.get(i + 2);
                res = Math.min(res, 2 * (max - min));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}