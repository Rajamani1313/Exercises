//public class LinkedListSum {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode res = null;
//        ListNode node = null;
//
//        int carry = 0;
//        while (l1 != null || l2 != null || carry>0)
//        {
//            if (res != null)
//            {
//                node.next = new ListNode();
//                node = node.next;
//            }
//            else {
//                node = new ListNode();
//                res = node;
//            }
//            node.next = null;
//            if (l1 != null){
//                carry += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null){
//                carry += l2.val;
//                l2 = l2.next;
//            }
//            node.val = carry % 10;
//            carry /= 10;
//        }
//        return res;
//    }
//}