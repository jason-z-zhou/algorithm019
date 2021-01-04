class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        int len = Integer.MAX_VALUE;

        for(String str: strs) {
            len = Math.min(len, str.length());
        }

        int size = 0;

        boolean quit = false;
        for(int i=0; i<len; i++) {
            char ch = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i) != ch) {
                    quit = true;
                }
            }
            if(quit) break;
            size ++;
        }

        return strs[0].substring(0, size);
    }

}
