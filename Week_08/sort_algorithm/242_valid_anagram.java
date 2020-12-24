class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] bucket = new int[26];

        for(char ch: s.toCharArray()) {
            bucket[ch - 'a'] ++;
        }

        for(char ch: t.toCharArray()) {
            bucket[ch - 'a'] --;
        }

        for(int b : bucket) {
            if (b != 0) return false;
        }

        return true;
    }

}
