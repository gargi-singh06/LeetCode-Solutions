class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int open = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                open++;
            } else if (sb.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    sb.setCharAt(i, '#');
                }
            }
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) {
                sb.setCharAt(i, '#');
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (c != '#') res.append(c);
        }
        return res.toString();
    }
}