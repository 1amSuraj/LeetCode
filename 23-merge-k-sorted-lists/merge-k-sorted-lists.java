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
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));
        for(ListNode ln:lists){
            while(ln!=null){
                heap.offer(ln);
                ln = ln.next;
            }
        }
        if(heap.isEmpty()) return null;
        ListNode cur = heap.poll();
        ListNode dummy = new ListNode(0,cur);
        while(!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
        
    }
}