class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] b=Arrays.copyOf(nums1,nums1.length + nums2.length);
        System.arraycopy(nums2,0,b,nums1.length,nums2.length);
        Arrays.sort(b);
        int n=b.length;
        int n1=(int)(n/2);
        if(n%2==0){
            int a=b[n1]+b[n1-1];
            return(a/2.0);
        }
        else{
            return(b[n1]);
        }
    }
}