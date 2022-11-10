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
        // if(head==null) return head;
        // ListNode prev, curr, nextCurr;
        // prev=head;
        // curr=head.next;
        // prev.next=null;
        // while(curr!=null) {
        //     nextCurr=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=nextCurr;
        // }
        // return prev;
        if(head==null) return head;
        ListNode prev=null, curr=head, next=head.next;
        while(curr!=null) {
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null)
                next=next.next;
        }
        return prev;
        // return reverseTheList(head, null);
    }
    
    public ListNode reverseTheList(ListNode head, ListNode prev) {
        if(head!=null) {
            ListNode x = reverseTheList(head.next, head);
            head.next=prev;
            return x;
        }
        return prev; 
    }
}