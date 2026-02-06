class Solution {
    public boolean isPalindrome(int x) {
        boolean bool=false;
        int old=x;
        int rev=0;
        if(x<0){
            bool=false;
        }
        else{
            while(x>0){
                int rem=x%10;
                rev=rev*10+rem;
                x=(int)x/10;
            }
            if(rev==old){
                bool=true;
            }
            else{
                bool=false;
            }
        }
        return bool;
    }
}