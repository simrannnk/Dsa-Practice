class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null && list2==null)
        {
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        ListNode c1=list1, c2=list2;
        while(c1!=null && c2!=null)
        {
            if(c1.val>c2.val)
            {
                prev.next=c2;
                prev=prev.next;
                c2=c2.next;
            }
            
            else{
                prev.next=c1;
                prev=prev.next;
                c1=c1.next;
            }
        }
        
        if(c1!=null)
        {
            prev.next=c1;
        }
        
        if(c2!=null)
        {
            prev.next=c2;
        }
        return dummy.next;
    }
}