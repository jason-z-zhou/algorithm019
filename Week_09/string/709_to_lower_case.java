class Solution {
    public String toLowerCase(String str) {
        char[] res = new char[str.length()];

        for(int i=0; i<str.length(); i++) {
            char oldChar = str.charAt(i);
            if(oldChar >= 'A' && oldChar <='Z') {
                res[i] = (char)(oldChar - 'A' + 'a');
            } else {
                res[i] = oldChar;
            }
        }

        return new String(res);
    }

}
