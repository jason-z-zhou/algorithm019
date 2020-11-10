class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();

        char[] chs = s.toCharArray();

// To ensure stack not empty
        stack.push('?');
        for(int i=0; i<chs.length; i++){
            if(chs[i] == '(' ){
                stack.push(')');
            } else if (chs[i] == '[' ){
                stack.push(']');
            } else if(chs[i] == '{' ){
                stack.push('}');
            } else {
                Character ch = stack.pop();
                if(ch != chs[i]) return false;
            }
        }

        return stack.size() == 1;
    }
}
