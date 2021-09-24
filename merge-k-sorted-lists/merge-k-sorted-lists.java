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
    public ListNode mergeKLists(ListNode[] lists){ 
        // Use divide-and-conquer to merge all of them with O(log)
        int begin = 0, end = lists.length - 1; 
            
        // Base cases
        if (lists == null || lists.length == 0) return null;
        
        while (begin < end){
            int middle = (begin + end - 1) / 2;
            for (int i = 0; i <= middle; i++){
                lists[i] = mergetwoLists(lists[i], lists[end - i]); // Merge lists               two by two
            }
            end = (begin + end) / 2;    // Divide and Conquer
        }
        return lists[0];
    }
    
    // Implement merge two lists as a helper method

    public ListNode mergetwoLists(ListNode l1, ListNode l2){
            ListNode head = new ListNode(0);
            ListNode n = head;
            ListNode m1 = l1;
            ListNode m2 = l2;
            
            while(m1 != null && m2 != null){
                if (m1.val < m2.val){
                    n.next = m1;
                    m1 = m1.next;
                }else{
                    n.next = m2;
                    m2 = m2.next;
                }
                n = n.next;
            }
            
            if (m1 != null){
                n.next = m1;
            }
            if(m2 != null){
                n.next = m2;
            }
            
            return head.next;
    }
}