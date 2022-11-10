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
    ListNode head, tail;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        head=null;
        tail=null;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val)
                l1=addToHead(l1);
            else
                l2=addToHead(l2);
        }
        while(l1!=null)
            l1=addToHead(l1);
        while(l2!=null)
            l2=addToHead(l2);
        return head;
        
    }
    
    public ListNode addToHead(ListNode l) {
        ListNode n=l;
        l=l.next;
        n.next=null;
        if(head==null) {
            head=n;  
            tail=n;
        }
        else {
            tail.next=n;
            tail=tail.next;
        }
        return l;
    } 
}