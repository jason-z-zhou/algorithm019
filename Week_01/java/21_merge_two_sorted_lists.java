/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null) return l2;
        if( l2 == null) return l1;

        ListNode current = new ListNode(-2^31 + 1);

        ListNode dummy = current;

        while(l1 != null || l2 != null) {

            if( l1 == null) {
                current.next = l2;
                break;
            }

            if( l2 == null) {
                current.next = l1;
                break;
            }

            if( l1.val >= l2.val){
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            } else {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
        }
        return dummy.next;
    }

}
