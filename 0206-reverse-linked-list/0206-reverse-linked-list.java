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
    public ListNode reverseList(ListNode head) {
        return recursion(head);
    }
    public ListNode recursion(ListNode temp){
        if(temp==null || temp.next==null){
            return temp;
        }
        ListNode future=recursion(temp.next);
        temp.next.next=temp;
        temp.next=null;
        return future;
    }
}