class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long)1e18;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (can(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean can(long time, int height, int[] workers) {
        long total = 0;
        for (int t : workers) {
            long low = 0, high = (long)1e6;
            while (low <= high) {
                long k = (low + high) / 2;
                long cost = t * k * (k + 1) / 2;
                if (cost <= time) {
                    low = k + 1;
                } else {
                    high = k - 1;
                }
            }
            total += high;
            if (total >= height) return true;
        }
        return false;
    }
}