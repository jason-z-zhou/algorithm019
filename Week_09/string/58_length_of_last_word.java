class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length();

        while(end > 0 && s.charAt(end-1) == ' ') end --;

        int count = 0;
        for(int i=0; i<end; i++) {
            if(s.charAt(i) == ' ') count = 0;
            else count++;

        }

        return count;
    }
}
