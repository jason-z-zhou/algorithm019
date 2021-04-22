class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        HashMap<Character, String> lookup = new HashMap<>();

        lookup.put('2', "abc");
        lookup.put('3', "def");
        lookup.put('4', "ghi");
        lookup.put('5', "jkl");
        lookup.put('6', "mno");
        lookup.put('7', "pqrs");
        lookup.put('8', "tuv");
        lookup.put('9', "wxyz");

        dfs(res, "", digits, 0, lookup);

        return res;

    }

    private void dfs(List<String> res, String path, String digits, int index, HashMap<Character, String> lookup) {
        if(index == digits.length()) {
            res.add(path);
            return;
        }

        String letters = lookup.get(digits.charAt(index));

        for(int i=0; i<letters.length(); i++) {
            dfs(res, path + letters.charAt(i), digits, index+1, lookup);
        }

    }
}
