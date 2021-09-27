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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use Two Pointer Technique: Fast and Slow pointer
        ListNode fast = head;
        ListNode slow = head;
        
        // Move the Fast pointer n steps ahead
        for (int i = 0; i < n; i++){
            
            // Edge case 1: If fast points to null, remove the head
            if(fast.next == null){
                
                // Edge case 2: If i = n-1, also remove the head
                if(i == n-1){
                    head = head.next;
                }
                return head;
            }
            fast = fast.next; 
        }
        
        // Simutaneously move Fast and Slow pointer, stop when fast.next == null
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from the list
        slow.next = slow.next.next;
        
        return head;
    }
}