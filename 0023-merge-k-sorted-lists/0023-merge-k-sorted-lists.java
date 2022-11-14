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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node: lists) {
            if(node!=null) queue.add(node);
        }
        var dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail=tail.next;
            if(tail.next!=null) queue.add(tail.next);
        }
        return dummy.next;
    }
}