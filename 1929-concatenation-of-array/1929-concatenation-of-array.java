class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[]ans=Arrays.copyOf(nums, 2*n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }
}