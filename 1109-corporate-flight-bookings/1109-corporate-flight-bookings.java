class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] b : bookings) {
            int l = b[0] - 1;
            int r = b[1] - 1;
            int seats = b[2];
            diff[l] += seats;
            if (r + 1 < n) diff[r + 1] -= seats;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}