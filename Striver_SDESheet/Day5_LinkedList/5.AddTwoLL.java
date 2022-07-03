class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null && l2==null)
        {
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode c1=l1,c2=l2;
        int carry=0;
        
        while(c1!=null || c2!=null || carry!=0)
        {
            int sum=carry+(c1!=null ? c1.val :0)+(c2!=null?c2.val:0);
            int ans=sum%10;
            carry=sum/10;
            
            prev.next=new ListNode(ans);
            prev=prev.next;
            
            if(c1!=null)
            {
                c1=c1.next;
            }
            
            if(c2!=null)
            {
              c2=c2.next;   
            }
        }
        
        return dummy.next;
        
    }
}