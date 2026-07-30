class Solution {
    public int minimumPushes(String word) {
        int num=0;
        if(word.length()<=8){
            num=word.length();
        }
        else if(word.length()>8 && word.length()<=16){
            num= 8 + 2*(word.length()-8);
        }
        else if(word.length()>16 && word.length()<=24){
            num = 24 + 3*(word.length()-16);
        }
        else{
            num = 48 + 4*(word.length()-24);
        }
        return num;
    }
}