import java.util.*;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        // Step 1: sort
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; // defense desc
            return a[0] - b[0]; // attack asc
        });

        int maxDefense = 0;
        int weak = 0;

        // Step 2: traverse from right
        for (int i = properties.length - 1; i >= 0; i--) {
            int defense = properties[i][1];

            if (defense < maxDefense) {
                weak++;
            }

            maxDefense = Math.max(maxDefense, defense);
        }

        return weak;
    }
}