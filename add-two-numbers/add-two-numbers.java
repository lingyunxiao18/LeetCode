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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize the returned list
        ListNode sumList = new ListNode(0); // sentinel node of 0
        ListNode curr = sumList;
        // Case for carrying
        int carry = 0;
        // Initialize the head of l1 and l2
        ListNode x = l1; ListNode y = l2;
    
        // Loop with conditions: l1 not empty or l2 not empty
        while (x != null || y != null) {
            // If at the end of the list, set p = 0
            int p = (x != null)? x.val : 0;
            int q = (y != null)? y.val : 0;
            int sum = p + q + carry;
            
            // Update carry and curr
            carry = sum / 10; // either 0 or 1
            curr.next = new ListNode(sum % 10); // add unit's digit to sumList
            curr = curr.next; 
            
            // If not at the end, move the head of the lists
            if (x != null){
                x = x.next;
            }
            if (y != null){
                y = y.next;
            }
        }
        
        // Special case like 99 + 1 = 100 
        if (carry == 1){
            curr.next = new ListNode(carry);
        }
        
        return sumList.next; // Note that we have included a sentinel node of 0
    }
}