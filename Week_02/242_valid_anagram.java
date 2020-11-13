class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> lookup = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(lookup.containsKey(charS)){
                lookup.put(charS, lookup.get(charS) + 1);
            } else {
                lookup.put(charS, 1);
            }

            if(lookup.containsKey(charT)){
                lookup.put(charT, lookup.get(charT) - 1);
            } else {
                lookup.put(charT, -1);
            }
        }

        for(int v : lookup.values()) {
            if(v != 0) return false;
        }

        return true;


    }
}
