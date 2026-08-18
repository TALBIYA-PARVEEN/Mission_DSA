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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        for(int i=0;i<left-1;i++)prev=prev.next;
        ListNode tailBefore=prev;
        ListNode subListHead=prev.next;
        
        ListNode subListTail=subListHead;
        for(int i=0;i<right-left;i++){
            subListTail=subListTail.next;
        }
        ListNode tailAfter=subListTail.next;
        subListTail.next=null;

        ListNode reverseHead=reverse(subListHead);

        tailBefore.next=reverseHead;
        subListHead.next=tailAfter;
        return dummy.next;
    }
    public ListNode reverse(ListNode temp){
        if(temp.next==null || temp==null){
            return temp;
        }
        ListNode future=reverse(temp.next);
        temp.next.next=temp;
        temp.next=null;
        return future;
    }
}