class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder res = new StringBuilder();
        backtrack(n, k, res, new StringBuilder());
        return res.toString();
    }
    private int count = 0;
    private void backtrack(int n, int k, StringBuilder res, StringBuilder curr) {
        if (res.length() > 0) return;
        if (curr.length() == n) {
            count++;
            if (count == k) {
                res.append(curr.toString());
            }
            return;
        }
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch) continue;
            curr.append(ch);
            backtrack(n, k, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}