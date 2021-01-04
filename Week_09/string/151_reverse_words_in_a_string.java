class Solution {
    public String reverseWords(String s) {

        String[] strs = s.split(" ");
        String res = "";

        for(int i=0; i< strs.length; i++) {
            System.out.println(i + ":" +strs[i]);
        }

        for(int i=strs.length-1; i>=0; i--) {
            if(! strs[i].equals("")) {
                res = res + strs[i] + " ";
            }
        }

        return res.substring(0, res.length() - 1);
    }
}
