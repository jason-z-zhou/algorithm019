import java.util.List
import java.util.LinkedList

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<Integer> res = new LinkedList<>();

        for(int num : arr) {
            for(int[] piece : pieces) {
                if(num == piece[0]) {
                    for(int p: piece) {
                        res.add(p)
                    }
                }
            }
        }

        if (res.size() != arr.length) return false;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != res.get(i)) return false;
        }

        return false;
    }
}
