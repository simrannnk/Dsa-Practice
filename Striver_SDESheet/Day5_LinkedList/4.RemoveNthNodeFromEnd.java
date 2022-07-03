class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head==null || n<1)
        {
            return null;
        }
        
        ListNode slow=head;
        ListNode fast=head;
       ListNode prev=head;  
        
        while(n-->0)
        {
            fast=fast.next;
        }
        if(fast==null)
        {
            return head.next;
        }
        
        while(fast!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
            prev.next=slow.next;
            slow.next=null;
        
        return head;
    }
}