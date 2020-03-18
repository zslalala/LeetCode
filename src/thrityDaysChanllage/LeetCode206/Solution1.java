package thrityDaysChanllage.LeetCode206;

public class Solution1 {

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode tempNode = head.next;
        while(tempNode != null){
            head.next = pre;
            System.out.println(head.val);
            pre = head;
            head = tempNode;
            tempNode = tempNode.next;
        }
        return head;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = null;

        System.out.println("逆转前");
        ListNode p = head;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }

        Solution1 solution1 = new Solution1();
        head = solution1.reverseList(head);

        System.out.println("逆转后");
        p = head;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
