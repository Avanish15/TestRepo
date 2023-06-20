class Solution {
    public ListNode oddEvenList(ListNode head) {
    ListNode es=null,ee=null,os=null,oe = null;
    // es->even start  ee->even end  os->odd start  oe->odd end
    int count=0;
    ListNode curr = head;
    while(curr!=null){
            count++;
            if(count%2 != 0){  if(os==null) {os = oe = curr;}  
            else  {oe.next = curr;  oe = oe.next; } 
    }
    else{
        if(es==null){
        es = ee = curr;}
        else{
        ee.next = curr;
        ee = ee.next;
    }}
    curr = curr.next;
    }
    if(os==null || es==null)   return head;
    oe.next = es;
    ee.next = null;    
    return os;
    }
}