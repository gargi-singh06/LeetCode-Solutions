import java.util.*;
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
        Stack<Integer> stack = new Stack<>();
        for (int i : idx) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int j = stack.peek();
                    if (healths[j] < healths[i]) {
                        stack.pop();
                        healths[i]--;
                        healths[j] = 0;
                    } else if (healths[j] > healths[i]) {
                        healths[j]--;
                        healths[i] = 0;
                        break;
                    } else {
                        stack.pop();
                        healths[i] = 0;
                        healths[j] = 0;
                        break;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) res.add(healths[i]);
        }
        return res;
    }
}