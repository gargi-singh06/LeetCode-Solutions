class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int[] arr=new int[n];
       arr[0]=prices[0];
       for(int i=1;i<n;i++){
        arr[i]=Math.min(prices[i],arr[i-1]);
       }
       int max=0;
       for(int i=0;i<n;i++){
        max=Math.max(max,prices[i]-arr[i]);
       }
       return max;
    }
}