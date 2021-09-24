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
        // Compare the head of the lists, replace the tail with the list with SMALLER value of head
        
        // Initialize the final list with an iterator
        ListNode head = new ListNode(0);
        ListNode n = head; 
        
        // Use Iteration to move the pointers
        ListNode m1 = l1;
        ListNode m2 = l2;
        while (m1 != null && m2 != null){
            if (m1.val < m2.val){
                n.next = m1;
                m1 = m1.next;
            }else{
                n.next = m2;
                m2 = m2.next;
            }
            n = n.next;
        }
        
        // Edge cases when either m1 or m2 is null at the end of the list
        if (m1 != null){
            n.next = m1;
        }
        if (m2 != null){
            n.next = m2;
        }
        
        return head.next;
    }
}