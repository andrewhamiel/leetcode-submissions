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
        if(lists == null || lists.length == 0) return null;
         return mergeKLists(lists, 0, lists.length-1);
    }
        
    public static ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start==end) return lists[start];
         int mid = start + ( end - start) / 2;

         ListNode left = mergeKLists(lists,start,mid);
         ListNode right = mergeKLists(lists,mid+1,end);
         return merge(left,right);
    }

    public static ListNode merge(ListNode left,ListNode right){
        ListNode res = new ListNode(0), curNode = res;

         while(left != null || right != null){
             if(left == null){
                 curNode.next = right;
                 right = right.next;
             }
             else if(right == null){
                 curNode.next = left;
                 left = left.next;
             }else if(left.val < right.val){
                 curNode.next = left;
                 left = left.next;
             }else{
                 curNode.next = right;
                 right = right.next;
             }
             curNode = curNode.next;
         }
         return res.next;
        }
}