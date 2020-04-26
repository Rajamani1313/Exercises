//public boolean isPalindrome(ListNode head) {
//        if(head == null || head.next == null) {
//        return true;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        // Move slow pointer to the middle node of the LL
//        while(fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//        }
//
//        // If there are odd number of nodes, move slow to the node after the middle node
//        if(fast != null) {
//        slow = slow.next;
//        }
//
//        // Take the slow pointer and reverse the links of the 2nd half of the LL
//        ListNode prev = null;
//        while(slow != null) {
//        ListNode tmp = slow.next;
//        slow.next = prev;
//        prev = slow;
//        slow = tmp;
//        }
//
//        // Compare the reversed 2nd half LL with the 1st half LL
//        ListNode tmpHead = head;
//        while(prev != null) {
//        if(prev.val != tmpHead.val) {
//        return false;
//        }
//        tmpHead = tmpHead.next;
//        prev = prev.next;
//        }
//        return true;
//        }