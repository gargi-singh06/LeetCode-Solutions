class Solution {
    public String triangleType(int[] nums) {
        String abc = "abc";
        if(nums[0]==nums[1]&&nums[0]==nums[2]&&nums[1]==nums[2]){
            abc = "equilateral";
        }
        else if(nums[0]!=nums[1]&&nums[0]!=nums[2]&&nums[1]!=nums[2]&&nums[0]+nums[1]>nums[2]&&nums[0]+nums[2]>nums[1]&&nums[1]+nums[2]>nums[0]){
            abc = "scalene";
        }
        else if ((nums[0]==nums[1] || nums[0]==nums[2] || nums[1]==nums[2])&&(nums[0]+nums[1]>nums[2]&&nums[0]+nums[2]>nums[1]&&nums[1]+nums[2]>nums[0])){
            abc = "isosceles";
        }
        else{
            abc = "none";
        }
        return abc;
    }
}