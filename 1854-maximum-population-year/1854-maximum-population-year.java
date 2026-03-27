class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            int birth = log[0] - 1950;
            int death = log[1] - 1950;
            years[birth]++;
            years[death]--;
        }
        int maxPop = 0, year = 0, curr = 0;
        for (int i = 0; i < 101; i++) {
            curr += years[i];
            if (curr > maxPop) {
                maxPop = curr;
                year = i;
            }
        }
        return 1950 + year;
    }
}