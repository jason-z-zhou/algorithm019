class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int[] bucket = new int[52];

        for(int i=0; i<stones.length(); i++) {
            char stone = stones.charAt(i);
            if(stone >= 'a' && stone <= 'z') {
                bucket[stone - 'a' + 26] ++;
            } else {
                bucket[stone - 'A'] ++;
            }
        }

        int sum = 0;
        for(int i=0; i<jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            if(jewel >= 'a' && jewel <= 'z') {
                sum += bucket[jewel - 'a' + 26];
            } else {
                sum += bucket[jewel - 'A'];
            }
        }
        return sum;
    }

}
