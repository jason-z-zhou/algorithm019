class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == len) return "0";
        if(k == 0) return num;

        char[] digits = num.toCharArray();
        Deque<Character> deque = new LinkedList<Character>();

        // Remove digits less than current digit
        for(int i=0; i<len; i++){
            char digit = digits[i];
            while(!deque.isEmpty() && k>0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.addLast(digit);
        }

        // If the deque size is still > k, start remove them from the rear
        for(int i=0; i<k; i++){
            deque.pollLast();
        }

        // Normalize the nums
        StringBuilder result = new StringBuilder();

        boolean startWithZero = true;

        while(!deque.isEmpty()) {
            char digit = deque.pollFirst();

            if(startWithZero && digit == '0') {
                continue;
            }

            startWithZero = false;
            result.append(digit);
        }
        return result.length()==0?"0":result.toString();
    }

}
