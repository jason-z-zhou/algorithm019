class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> lookup = new HashMap<>();

        for (String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);

            if(lookup.containsKey(key)) {
                List<String> value = lookup.get(key);
                value.add(str);
                lookup.put(key, value);
            } else {
                List<String> value = new ArrayList<String>();
                value.add(str);
                lookup.put(key, value);
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();

        for(List<String> value : lookup.values()){
            res.add(value);
        }
        return res;
    }

}
