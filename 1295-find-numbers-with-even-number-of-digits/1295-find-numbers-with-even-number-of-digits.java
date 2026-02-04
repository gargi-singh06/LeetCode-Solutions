class Solution {
    public int findNumbers(int[] nums) {
        int add=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0){
                nums[i]=(int)nums[i]/10;
                count++;
            }
            if(count % 2==0){
                add++;
                count=0;
            }
            else{
                count=0;
                continue;
            }
        }
        return add;
    }
}