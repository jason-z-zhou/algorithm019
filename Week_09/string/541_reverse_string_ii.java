class Solution {
    public String reverseStr(String s, int k) {
        int start = 0;

        char[] chs = s.toCharArray();

        boolean skip = false;
        while(start < chs.length) {
            int end = (start + k - 1) < chs.length - 1 ? start + k - 1 : chs.length -1;
            if(!skip) {
                for(int i=start, j=end; i<j; i++, j--) {
                    char tmp = chs[i];
                    chs[i] = chs[j];
                    chs[j] = tmp;
                }
            }

            start += k;
            skip = !skip;
        }

        return new String(chs);
    }
}
